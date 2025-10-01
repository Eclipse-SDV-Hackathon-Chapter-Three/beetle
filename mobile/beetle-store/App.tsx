import React from 'react';
import { createTheme, ThemeProvider } from '@rneui/themed';
import { SafeAreaProvider } from 'react-native-safe-area-context';
import Header from './src/components/Header';
import { TabProvider } from './src/context/TabContext';
import BottomTabs from './src/components/BottomTabs';
import TabView from './src/components/TabView';

const theme = createTheme({
  lightColors: {},
  darkColors: {},
});

export default function App() {
  return (
    <SafeAreaProvider>
      <TabProvider>
        <ThemeProvider theme={theme}>
          <Header title="Beetle" />
          <TabView />
          <BottomTabs />
        </ThemeProvider>
      </TabProvider>
    </SafeAreaProvider>
  );
}
