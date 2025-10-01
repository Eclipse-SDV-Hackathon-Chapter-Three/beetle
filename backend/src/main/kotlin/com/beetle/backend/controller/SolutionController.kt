package com.beetle.backend.controller

import com.beetle.backend.client.request.SolutionRequest
import com.beetle.backend.service.SolutionService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/solutions")
class SolutionController(private val solutionService: SolutionService) {

    @PostMapping
    fun createSolution(@RequestBody solutionRequest: SolutionRequest) {
        solutionService.createSolution(solutionRequest)
    }

}