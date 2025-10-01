import React from 'react';
import { useTab } from '../context/TabContext';
import Catalog from '../screens/Catalog';
import VehicleInfo from '../screens/VehicleInfo';

const TabView = () => {
  const { currentTab } = useTab();

  switch (currentTab) {
    case 'vehicle':
      return <VehicleInfo />;
    case 'catalog':
    default:
      return <Catalog />;
  }
};

export default TabView;
