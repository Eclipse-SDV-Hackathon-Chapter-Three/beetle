import React from 'react';
import { StyleSheet, View } from 'react-native';
import { Header as HeaderRNE, Icon } from '@rneui/themed';
import { TouchableOpacity } from 'react-native-gesture-handler';

type HeaderComponentProps = {
  title: string;
  view?: string;
};

const Header: React.FunctionComponent<HeaderComponentProps> = (props) => {
  return (
    <HeaderRNE
      leftComponent={{
        icon: 'menu',
        color: '#fff',
      }}
      rightComponent={
        <View style={styles.headerRight}>
          <TouchableOpacity>
            <Icon name="description" color="white" />
          </TouchableOpacity>
        </View>
      }
      centerComponent={{ text: props.title, style: styles.heading }}
    />
  );
};

const styles = StyleSheet.create({
  headerContainer: {
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#397af8',
    marginBottom: 20,
    width: '100%',
    paddingVertical: 15,
  },
  heading: {
    color: 'white',
    fontSize: 22,
    fontWeight: 'bold',
  },
  headerRight: {
    display: 'flex',
    flexDirection: 'row',
    marginTop: 5,
  },
  subheaderText: {
    color: 'white',
    fontSize: 16,
    fontWeight: 'bold',
  },
});

export default Header;
