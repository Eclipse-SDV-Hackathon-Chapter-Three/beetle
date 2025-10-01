package com.beetle.backend.controller

import com.beetle.backend.client.request.SolutionRequest
import com.beetle.backend.client.response.SolutionResponse
import com.beetle.backend.service.SolutionService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/solutions")
class SolutionController(private val solutionService: SolutionService) {

    @PostMapping
    fun createSolution(@RequestBody solutionRequest: SolutionRequest) {
        solutionService.createSolution(solutionRequest)
    }

    @GetMapping("/{solutionName}")
    fun getSolution(@PathVariable solutionName: String): SolutionResponse? {
        return solutionService.getSolution(solutionName)
    }

}