import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import VehicleRow, { VehicleData } from './VehicleRow';

const vehicles: VehicleData[] = [
  {
    id: 1,
    name: 'Volkswagen Golf',
    features: [
      { name: 'ABS', value: 'ABS', status: 'Active' },
      { name: 'Airbag', value: 'Airbag', status: 'Active' },
      { name: 'Alarm', value: 'Alarm', status: 'Deactivated' },
      { name: 'Blind Spot Monitor', value: 'Blind Spot Monitor', status: 'Active' },
      { name: 'Central Locking', value: 'Central Locking', status: 'Active' },
      { name: 'Cruise Control', value: 'Cruise Control', status: 'Active' },
      { name: 'Electric Windows', value: 'Electric Windows', status: 'Update available' },
    ],
  },
  {
    id: 2,
    name: 'Volkswagen Jetta',
    features: [
      { name: 'ABS', value: 'ABS', status: 'Active' },
      { name: 'Airbag', value: 'Airbag', status: 'Active' },
      { name: 'Alarm', value: 'Alarm', status: 'Active' },
      { name: 'Blind Spot Monitor', value: 'Blind Spot Monitor', status: 'Active' },
      { name: 'Central Locking', value: 'Central Locking', status: 'Active' },
      { name: 'Cruise Control', value: 'Cruise Control', status: 'Active' },
      { name: 'Electric Windows', value: 'Electric Windows', status: 'Active' },
    ],
  },
  {
    id: 3,
    name: 'Volkswagen Tiguan',
    features: [
      { name: 'ABS', value: 'ABS', status: 'Active' },
      { name: 'Airbag', value: 'Airbag', status: 'Active' },
      { name: 'Alarm', value: 'Alarm', status: 'Active' },
      { name: 'Blind Spot Monitor', value: 'Blind Spot Monitor', status: 'Active' },
      { name: 'Central Locking', value: 'Central Locking', status: 'Active' },
      { name: 'Cruise Control', value: 'Cruise Control', status: 'Active' },
      { name: 'Electric Windows', value: 'Electric Windows', status: 'Active' },
    ],
  },
];

export default function VehiclesTable() {
  return (
    <TableContainer component={Paper}>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Name</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {vehicles.map((vehicle) => (
            <VehicleRow vehicle={vehicle} />
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
