import { useState } from 'react';
import Box from '@mui/material/Box';
import Collapse from '@mui/material/Collapse';
import Typography from '@mui/material/Typography';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import KeyboardArrowUpIcon from '@mui/icons-material/KeyboardArrowUp';
import DownloadIcon from '@mui/icons-material/Download';
import SystemUpdateAltIcon from '@mui/icons-material/SystemUpdateAlt';
import AppBlockingIcon from '@mui/icons-material/AppBlocking';
import IconButton from '@mui/material/IconButton';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Button from '@mui/material/Button';

export type FeatureStatus = 'Active' | 'Update available' | 'Deactivated';

export interface Feature {
  name: string;
  value: string;
  status: string;
}

export interface VehicleData {
  id: string;
  name: string;
  features: Feature[];
}

export interface VehicleRowProps {
  vehicle: VehicleData;
}

function getActions(feature: Feature) {
  switch (feature.status) {
    case 'Active':
      return <Button startIcon={<AppBlockingIcon color='warning' />}>Deactivate</Button>;
    case 'Update available':
      return <Button startIcon={<SystemUpdateAltIcon />}>Update</Button>;
    case 'Deactivated':
      return <Button startIcon={<DownloadIcon color='success' />}>Activate</Button>;
    default:
      return null;
  }
}

export default function VehicleRow(props: VehicleRowProps) {
  const { vehicle } = props;
  const [open, setOpen] = useState(false);

  return (
    <>
      <TableRow
        sx={{ '& > *': { borderBottom: 'unset' } }}
        key={`${String(vehicle.id)}-${vehicle.name.toLowerCase().replace(/\s/, '-')}`}
      >
        <TableCell component='th' scope='row'>
          <IconButton aria-label='expand row' size='small' onClick={() => setOpen(!open)} sx={{ marginRight: 1 }}>
            {open ? <KeyboardArrowUpIcon /> : <KeyboardArrowDownIcon />}
          </IconButton>
          {vehicle.id} - {vehicle.name}
        </TableCell>
      </TableRow>
      <TableRow>
        <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={6}>
          <Collapse in={open} timeout='auto' unmountOnExit>
            <Box sx={{ margin: 1 }}>
              <Typography variant='h6' gutterBottom component='div'>
                Features
              </Typography>
              <Table size='small' aria-label='features'>
                <TableHead>
                  <TableRow>
                    <TableCell>Name</TableCell>
                    <TableCell>Status</TableCell>
                    <TableCell>Actions</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {vehicle.features.map((feature) => (
                    <TableRow key={feature.name}>
                      <TableCell component='th' scope='row'>
                        {feature.name}
                      </TableCell>
                      <TableCell>{feature.status}</TableCell>
                      <TableCell>{getActions(feature)}</TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </Box>
          </Collapse>
        </TableCell>
      </TableRow>
    </>
  );
}
