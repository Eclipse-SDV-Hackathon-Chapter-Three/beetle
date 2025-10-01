export interface DeviceDto {
  deviceId: string;
  status: string;
  installedSoftware?: TargetComponentRequest[];
  createdAt?: string;
  updatedAt?: string;
  prodMode: boolean;
  country?: string;
}

export interface TargetComponentRequest {
  id?: number;
  name?: string;
  type?: string;
  properties?: string;
}

export interface TargetEntity {
  id?: number;
  name?: string;
  displayName?: string;
  forceRedeploy?: boolean;
  labels?: string;
  components: TargetComponentEntity[];
  topologies: TopologyEntity[];
}

export interface TargetComponentEntity {
  id?: number;
  name?: string;
  type?: string;
  properties?: string;
  target?: TargetEntity;
}

export interface TopologyEntity {
  id?: number;
  target?: TargetEntity;
  bindings: BindingEntity[];
}

export interface BindingEntity {
  id?: number;
  role?: string;
  provider?: string;
  config?: string;
  topology?: TopologyEntity;
}
