export interface TargetRequestDto {
  metadata: {
    name: string;
  };
  spec: {
    forceRedeploy: boolean;
    components: any[];
    topologies: TopologySpec[];
  };
}

export interface TopologySpec {
  bindings: BindingSpec[];
}

export interface BindingSpec {
  role: string;
  provider: string;
  config: {
    name: string;
    brokerAddress: string;
    clientID: string;
    requestTopic: string;
    responseTopic: string;
    timeoutSeconds: string;
  };
}
