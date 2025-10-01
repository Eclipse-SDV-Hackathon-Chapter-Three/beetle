import * as React from 'react';
import Box from '@mui/material/Box';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Vehicles from './app/Vehicles';
import Typography from '@mui/material/Typography';

export default function App() {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position='static' sx={{ display: 'flex', minWidth: '100vw' }} className='mb-6'>
        <Toolbar className='flex justify-center'>
          <Typography variant='h4' component='h1'>
            Beetle
          </Typography>
        </Toolbar>
      </AppBar>

      <Box sx={{ width: 'auto', display: 'flex', paddingX: 12, paddingY: 8 }}>
        <Vehicles />
      </Box>
    </Box>
  );
}
