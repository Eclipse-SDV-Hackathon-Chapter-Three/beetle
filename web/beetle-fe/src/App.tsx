import * as React from 'react';
import Box from '@mui/material/Box';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Vehicles from './app/Vehicles';
import Typography from '@mui/material/Typography';

export default function App() {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position='sticky' sx={{ display: 'flex', minWidth: '100vw', justifyContent: 'start' }}>
        <Toolbar sx={{ display: 'flex', justifyContent: 'start', alignItems: 'center', gap: 1, width: '100%'}}>
          <img src='/beetle.png' style={{ width: 50, height: 50, marginRight: 8 }} />
          <Typography sx={{verticalAlign: 'text-bottom', fontSize: 32, fontFamily: 'VWHead-Bold'}}>
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
