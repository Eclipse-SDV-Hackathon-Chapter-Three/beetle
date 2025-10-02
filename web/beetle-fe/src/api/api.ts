import axios from 'axios';
import { DeviceDto } from './dto/DeviceDto';
import { TargetRequestDto } from './dto/TargetRequestDto';

const API_BASE_URL = 'http://localhost:8080/api';

const apiClient = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

export class ApiManager {
  static async getAnkaiosTarget(): Promise<DeviceDto> {
    const response = await apiClient.get<DeviceDto>('/targets/ankaios-target');
    return response.data;
  }

  static async createAnkaiosTarget(payload: TargetRequestDto): Promise<void> {
    await apiClient.post('/targets/ankaios-target', payload);
  }
}
