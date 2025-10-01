package com.beetle.backend.service

import com.beetle.backend.client.SolutionClient
import com.beetle.backend.client.request.SolutionContainerRequest
import com.beetle.backend.client.request.SolutionRequest
import org.springframework.stereotype.Service

@Service
class SolutionService(private var solutionClient: SolutionClient) {

    fun createSolutionContainer(solutionContainerRequest: SolutionContainerRequest) {
        solutionClient.createSolutionContainer(solutionContainerRequest)
    }

    fun createSolution(solutionSolutionRequest: SolutionRequest) =
        solutionClient.createSolution(solutionSolutionRequest)

}
