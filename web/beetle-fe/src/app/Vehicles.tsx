import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import VehiclesTable from '../components/VehiclesTable';

export default function Vehicles() {
  return (
    <Box
      sx={{ display: 'flex', width: '100%', flexDirection: 'column', alignItems: 'center', justifyContent: 'start' }}
    >
      <Typography variant='h5' component='h1' sx={{ marginY: 4 }}>
        Vehicles
      </Typography>

      <VehiclesTable />
    </Box>
  );
}
