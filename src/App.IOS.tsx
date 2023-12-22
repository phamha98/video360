import React, { useEffect, useRef, useState } from 'react';
import { Button, Dimensions, Image, View, useWindowDimensions, SafeAreaView, Modal, TouchableOpacity, BackHandler } from 'react-native';
import { Video360 } from './Video360';
import { StatusBar } from 'react-native';
import ButtonBack from './ButtonBack';


export default function App() {
  useEffect(() => {
    const backAction = () => {
      setVisible(false)
      return true;
    };
    const backHandler = BackHandler.addEventListener(
      'hardwareBackPress',
      backAction,
    );

    return () => backHandler.remove();
  }, []);
  const [visible, setVisible] = useState(false)
  if (visible)
    return (
      <SafeAreaView style={{ flex: 1 }} >
        <StatusBar hidden />

        <View onTouchStart={() => console.log('e')} style={{ flex: 1, backgroundColor: '#8000FF', }}>
          <ButtonBack onPress={() => setVisible(false)} />
          <Video360
            urlVideo='https://bitmovin-a.akamaihd.net/content/playhouse-vr/progressive.mp4'
            // urlVideo='https://adowindow.com/wp-content/uploads/video360.mp4'
            modeVideo={1}
            style={{ flex: 1 }}
            volume={1}
            controls={false}
          />
        </View >
      </SafeAreaView>
    )
  return (
    <SafeAreaView style={{ flex: 1 }} >
      <StatusBar hidden />
      <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
        <TouchableOpacity onPress={() => setVisible(true)} style={{ padding: 10, backgroundColor: '#eee', borderRadius: 10, borderWidth: 5, borderColor: '#f16da7' }}>
          <Image source={require('./kid.png')} style={{ width: 300, height: 300 }} />
        </TouchableOpacity>
      </View>
    </SafeAreaView>
  )
}

