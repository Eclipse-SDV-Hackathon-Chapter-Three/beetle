package com.beetle.backend.controller

import io.swagger.v3.oas.annotations.Hidden
import jakarta.persistence.EntityNotFoundException
import jakarta.validation.ConstraintViolationException
import org.slf4j.Logger
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus.*
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.security.access.AccessDeniedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


/** Catches exceptions during rest operations and returns proper responses. */
@ControllerAdvice
class GlobalExceptionHandler(private val logger_: Logger) : ResponseEntityExceptionHandler() {

    @ExceptionHandler(EntityNotFoundException::class)
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    protected fun handleExceptionNotFound(exception: Exception, request: WebRequest): ResponseEntity<Any>? {
        val status = NOT_FOUND
        logger_.warn("EntityNotFoundException (${status.value()}): ${exception.message}", exception)
        return handleExceptionInternal(exception, ErrorMessage(exception.message ?: status.reasonPhrase), HttpHeaders(), status, request)
    }

    @ExceptionHandler(IllegalArgumentException::class, ApplicationException::class, ConstraintViolationException::class, ConstraintViolationException::class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    protected fun handleExceptionBadRequest(exception: Exception, request: WebRequest): ResponseEntity<Any>? {
        val status = BAD_REQUEST
        val message = when (exception) {
            is ConstraintViolationException -> {
                exception.constraintViolations.joinToString(", ") {
                    "${it.propertyPath}: ${it.message}"
                }
            }
            else -> exception.message ?: status.reasonPhrase
        }
        logger_.warn("Bad Request (${status.value()}): $message", exception)
        return handleExceptionInternal(exception, ErrorMessage(exception.message ?: status.reasonPhrase), HttpHeaders(), status, request)
    }

    @ExceptionHandler(UnauthorizedException::class)
    @ResponseStatus(UNAUTHORIZED)
    @ResponseBody
    protected fun handleExceptionUnAuthorized(exception: Exception, request: WebRequest): ResponseEntity<Any>? {
        val status = UNAUTHORIZED
        logger_.warn("UnAuthorizedException (${status.value()}): ${exception.message}", exception)
        return handleExceptionInternal(exception, ErrorMessage(exception.message ?: status.reasonPhrase), HttpHeaders(), status, request)
    }

    @ExceptionHandler(AccessDeniedException::class)
    @ResponseStatus(FORBIDDEN)
    @ResponseBody
    protected fun handleExceptionForbidden(exception: Exception, request: WebRequest): ResponseEntity<Any>? {
        val status = FORBIDDEN
        logger_.warn("Forbidden (${status.value()}): ${exception.message}", exception)
        return handleExceptionInternal(exception, ErrorMessage(exception.message ?: status.reasonPhrase), HttpHeaders(), status, request)
    }

    @ExceptionHandler(RuntimeException::class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    protected fun handleExceptionInternal(exception: Exception, request: WebRequest): ResponseEntity<Any>? {
        val status = INTERNAL_SERVER_ERROR
        logger_.error("Internal server error (${status.value()}): ${exception.message}", exception)
        return handleExceptionInternal(exception, ErrorMessage(exception.message ?: status.reasonPhrase), HttpHeaders(), status, request)
    }

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        val errors = ex.bindingResult.fieldErrors.map {
            "${it.field}: ${it.defaultMessage}"
        }
        logger_.warn("Validation failed (${BAD_REQUEST.value()}): $errors")
        return handleExceptionInternal(ex, ErrorMessage(errors.toString()), HttpHeaders(), status, request)
    }

    override fun handleExceptionInternal(
        ex: Exception,
        body: Any?,
        headers: HttpHeaders,
        statusCode: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        return super.handleExceptionInternal(ex, body ?: ErrorMessage(ex.message ?: statusCode.toString()), headers, statusCode, request)
    }

    override fun handleHttpMessageNotReadable(
        ex: HttpMessageNotReadableException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        val message = "Invalid request format: ${ex.mostSpecificCause.message}"
        logger_.warn("Message not readable (${BAD_REQUEST.value()}): $message")

        return handleExceptionInternal(
            ex,
            ErrorMessage(message),
            headers,
            BAD_REQUEST,
            request
        )
    }

    data class ErrorMessage(val message: String)
}

class UnauthorizedException(override val message: String, override val cause: Throwable? = null) : RuntimeException(message, cause)

class ApplicationException(message: String, throwable: Throwable) : RuntimeException(message, throwable)
