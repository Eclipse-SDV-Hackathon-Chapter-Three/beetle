declare module 'react-native-speedometer-chart' {
  import { ComponentType } from 'react';

  interface SpeedometerProps {
    value: number;
    totalValue: number;
    size?: number;
    outerColor?: string;
    internalColor?: string;
    showText?: boolean;
    text?: string;
    textStyle?: object;
    showLabels?: boolean;
    labelStyle?: object;
    showPercent?: boolean;
    percentStyle?: object;
  }

  const Speedometer: ComponentType<SpeedometerProps>;
  export default Speedometer;
}
