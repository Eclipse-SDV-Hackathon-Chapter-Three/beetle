import React from 'react';
import { View, Text, StyleSheet } from 'react-native';
import Speedometer from 'react-native-speedometer-chart';
import { useDeviceSpeed } from '../hooks/useDeviceSpeed';
import { useTheme } from '@rneui/themed';

const VehicleInfo = () => {
  const { speed } = useDeviceSpeed();
  const { theme } = useTheme();

  return (
    <View style={styles.container}>
      <View style={styles.card}>
        <Text style={styles.title}>Vehicle Speed</Text>
        <View style={styles.speedContainer}>
          <Speedometer
            value={speed}
            totalValue={220}
            text={`${speed} km/h`}
            textStyle={styles.speedText}
            labelStyle={styles.speedText}
            showLabels
            showText
            internalColor={theme.colors.primary}
          />
        </View>
      </View>

      <View style={styles.card}>
        <Text style={styles.title}>Vehicle Status</Text>
        <Text style={styles.placeholder}>Battery: ---%</Text>
        <Text style={styles.placeholder}>Range: --- miles</Text>
      </View>

      <View style={styles.card}>
        <Text style={styles.title}>Location</Text>
        <Text style={styles.placeholder}>Current Location: ---</Text>
        <Text style={styles.placeholder}>Last Updated: ---</Text>
      </View>

      <View style={styles.card}>
        <Text style={styles.title}>Trip Info</Text>
        <Text style={styles.placeholder}>Distance: --- miles</Text>
        <Text style={styles.placeholder}>Duration: --- min</Text>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 16,
    backgroundColor: '#f5f5f5',
  },
  card: {
    backgroundColor: '#fff',
    padding: 16,
    marginBottom: 16,
    borderRadius: 8,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.1,
    shadowRadius: 4,
    elevation: 3,
  },
  cardContent: {
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
  },
  title: {
    fontSize: 18,
    fontWeight: 'bold',
    marginBottom: 12,
  },
  placeholder: {
    fontSize: 14,
    color: '#666',
    marginBottom: 4,
  },
  speedContainer: {
    alignItems: 'center',
  },
  speedValue: {
    fontSize: 32,
    fontWeight: 'bold',
    textAlign: 'center',
    marginBottom: 8,
  },
  speedText: {
    fontSize: 18,
    fontWeight: 'bold',
    textAlign: 'center',
  },
});

export default VehicleInfo;
