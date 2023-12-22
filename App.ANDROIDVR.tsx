import React, { useEffect, useRef, useState } from 'react';
import { Button, Dimensions, Image, View, useWindowDimensions, SafeAreaView, Modal, TouchableOpacity, BackHandler } from 'react-native';
import { VideoVR } from './VideoVR';
import { StatusBar } from 'react-native';
import Svg, { Circle, Rect, Line, Path, Defs } from 'react-native-svg';
import SvgUri from 'react-native-svg-uri';


export default function App() {
  const { height, width } = Dimensions.get('screen')
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
        <View style={{ flex: 1, backgroundColor: '#8000FF', }}>
          <VideoVR
            urlVideo='https://bitmovin-a.akamaihd.net/content/playhouse-vr/progressive.mp4'
            // urlVideo='https://adowindow.com/wp-content/uploads/video360.mp4'
            modeVideo={2}
            style={{ flex: 1 }}
            volume={1}
            // displayMode='cardboard'
            displayMode='embedded'
            enableInfoButton={true}
            enableFullscreenButton={true}
            enableCardboardButton={true}
            enableTouchTracking={true}
            onLoadSuccess={(e) => { console.log('onLoadSuccess', e) }}
            onLoadError={(e) => { console.log('onLoadError', e) }}
            onNewFrame={(e) => { console.log('onNewFrame', e) }}
            onCompletion={(e) => { console.log('onCompletion', e) }}
          />
        </View >
      </SafeAreaView>
    )
  return (
    <SafeAreaView style={{ flex: 1 }} >
      <StatusBar hidden />
      <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
        <TouchableOpacity onPress={() => setVisible(true)} style={{ padding: 10, backgroundColor: '#eee', borderRadius: 10, borderWidth: 5, borderColor: '#f16da7' }}>
          <Image source={require('./src/kid.png')} style={{ width: 300, height: 300 }} />
        </TouchableOpacity>
      </View>
    </SafeAreaView>
  )
}
const ModalScreen = ({ visible = false }) => {
  const { height, width } = Dimensions.get('screen')
  return (
    <Modal visible={visible}>
      <View style={{ width, height, backgroundColor: 'red' }}>
        <SafeAreaView style={{ flex: 1 }} >
          <StatusBar hidden />
          <View style={{ flex: 1, backgroundColor: '#8000FF', }}>
            <VideoVR
              urlVideo='https://cdn.bitmovin.com/content/assets/playhouse-vr/progressive.mp4'
              // urlVideo='https://adowindow.com/wp-content/uploads/video360.mp4'
              modeVideo={2}
              style={{ flex: 1 }}
              volume={1}
              displayMode='embedded'
              enableInfoButton={true}
              enableFullscreenButton={true}
              enableCardboardButton={true}
              enableTouchTracking={true}
              onLoadSuccess={(e) => { console.log('onLoadSuccess', e) }}
              onLoadError={(e) => { console.log('onLoadError', e) }}
              onNewFrame={(e) => { console.log('onNewFrame', e) }}
              onCompletion={(e) => { console.log('onCompletion', e) }}
            />
          </View >
        </SafeAreaView>
      </View>
    </Modal>
  )
}

