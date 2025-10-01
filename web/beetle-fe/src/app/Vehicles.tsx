import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import VehiclesTable from '../components/VehiclesTable';
import { useEffect, useState } from 'react';
import { DeviceDto } from '../api/dto/DeviceDto';
import { ApiManager } from '../api/api';

export default function Vehicles() {
  const [devices, setDevices] = useState<DeviceDto[]>([]);
  const [loading, setLoading] = useState<boolean>(true);

  useEffect(() => {
    const fetchVehicles = async () => {
      const data = await ApiManager.getAnkaiosTarget();
      setDevices([data]);
      setLoading(false);
    };

    fetchVehicles();
  }, []);

  return (
    <Box
      sx={{ display: 'flex', width: '100%', flexDirection: 'column', alignItems: 'center', justifyContent: 'start' }}
    >
      <Typography variant='h5' component='h1' sx={{ marginY: 4 }}>
        Vehicles
      </Typography>

      <VehiclesTable devices={devices} loading={loading} />
    </Box>
  );
}
