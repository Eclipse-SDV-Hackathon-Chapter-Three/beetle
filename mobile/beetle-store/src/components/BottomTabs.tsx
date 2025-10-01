import React from 'react';
import { View, TouchableOpacity, Text, StyleSheet } from 'react-native';
import { useTab } from '../context/TabContext';

const BottomTabs = () => {
  const { currentTab, setCurrentTab } = useTab();

  return (
    <View style={styles.container}>
      <TouchableOpacity
        style={[styles.tab, currentTab === 'catalog' && styles.activeTab]}
        onPress={() => setCurrentTab('catalog')}
      >
        <Text
          style={[
            styles.tabText,
            currentTab === 'catalog' && styles.activeText,
          ]}
        >
          Catalog
        </Text>
      </TouchableOpacity>

      <TouchableOpacity
        style={[styles.tab, currentTab === 'vehicle' && styles.activeTab]}
        onPress={() => setCurrentTab('vehicle')}
      >
        <Text
          style={[
            styles.tabText,
            currentTab === 'vehicle' && styles.activeText,
          ]}
        >
          Vehicle
        </Text>
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flexDirection: 'row',
    backgroundColor: '#fff',
    borderTopWidth: 1,
    borderTopColor: '#e0e0e0',
  },
  tab: {
    flex: 1,
    paddingVertical: 16,
    alignItems: 'center',
  },
  activeTab: {
    backgroundColor: '#f0f0f0',
  },
  tabText: {
    fontSize: 16,
    color: '#666',
  },
  activeText: {
    color: '#000',
    fontWeight: 'bold',
  },
});

export default BottomTabs;
