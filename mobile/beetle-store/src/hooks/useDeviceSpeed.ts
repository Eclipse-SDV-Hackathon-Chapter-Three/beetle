import { useState, useEffect } from 'react';

export const useDeviceSpeed = () => {
  const [speed, setSpeed] = useState<number>(0);
  const [active, setActive] = useState<boolean>(true);

  useEffect(() => {
    let interval: NodeJS.Timeout;

    if (active) {
      interval = setInterval(() => {
        const randomSpeed = Math.floor(Math.random() * (120 - 80 + 1)) + 80;
        setSpeed(randomSpeed);
      }, 1000);
    } else {
      setSpeed(0);
    }

    return () => {
      if (interval) {
        clearInterval(interval);
      }
    };
  }, [active]);

  return { speed, active, setActive };
};
