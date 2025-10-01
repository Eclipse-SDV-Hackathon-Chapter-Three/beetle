import React from 'react';
import { ScrollView } from 'react-native';
import { PricingCard, lightColors, Icon, ButtonProps } from '@rneui/themed';

const ButtonIcon: React.FunctionComponent = () => {
  return <Icon type="material-community" name="car-connected" color="white" />;
};

const buttonProps: ButtonProps = {
  title: ' GET STARTED',
  icon: <ButtonIcon />,
  buttonStyle: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    padding: 14,
  },
  titleStyle: { marginLeft: 6 },
};

const Catalog: React.FunctionComponent = () => {
  return (
    <>
      <ScrollView>
        <PricingCard
          color={lightColors.primary}
          title="Auto Fuel Saving"
          price="30€"
          info={['Automatic gearbox management', 'Increased performance']}
          button={buttonProps}
        />
        <PricingCard
          color={lightColors.primary}
          title="Real-time Traffic"
          price="19€"
          info={['24/7 Traffic information', 'Current country support']}
          button={buttonProps}
        />
        <PricingCard
          color={lightColors.primary}
          title="Remote-Control"
          price="49€"
          info={['Control doors and windows of the vehicle remotely']}
          button={buttonProps}
        />
        <PricingCard
          color={lightColors.primary}
          title="Self-Rental"
          price="49€"
          info={['Rent your car when you are not using it']}
          button={buttonProps}
        />
      </ScrollView>
    </>
  );
};

export default Catalog;
