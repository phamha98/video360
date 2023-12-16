import React, { useEffect, useRef } from 'react';
import { Button, Dimensions, Image, View, useWindowDimensions } from 'react-native';
import { VideoVR } from './VideoVR';
import { StatusBar } from 'react-native';
import Svg, { Circle, Rect, Line, Path, Defs } from 'react-native-svg';
import SvgUri from 'react-native-svg-uri';
export default function App() {
  const { height, width } = useWindowDimensions();
  console.log({ width, height })



  const heightset = height - 30
  const bg1 = "#000"
  const wX = heightset * 0.8
  const w3 = wX * 0.15
  const h1 = (heightset - wX) / 2
  const w1 = (width - wX * 2 - w3) / 2
  return (
    <View style={{ flex: 1, backgroundColor: '#8000FF', }}>
      <StatusBar hidden />

      <View style={{ position: 'absolute', width, height: heightset, zIndex: 99 }}>
        <View style={{ width: width, height: h1, backgroundColor: bg1, }} />
        <View style={{ flexDirection: 'row' }}>
          <View style={{ width: w1, height: wX, backgroundColor: bg1, }} />
          <View style={{ height: wX, width: wX, backgroundColor: 'transparent', }} >
            <Image source={require("./eye3.png")} style={{ height: wX, width: wX, tintColor: '#000', resizeMode: 'contain' }} />
          </View>
          <View style={{ width: w3, height: wX, backgroundColor: bg1, }} />
          <View style={{ height: wX, width: wX, backgroundColor: 'transparent', }} >
            <Image source={require("./eye3.png")} style={{ height: wX, width: wX, tintColor: '#000', resizeMode: 'contain' }} />
          </View>
          <View style={{ width: w1, height: wX, backgroundColor: bg1, }} />
        </View>
        <View style={{ width: width, height: h1, backgroundColor: bg1 }} />
      </View>
      <VideoVR
        urlVideo='https://cdn.bitmovin.com/content/assets/playhouse-vr/progressive.mp4'
        modeVideo={2}
        style={{ flex: 1 }}
        volume={1}
        displayMode='cardboard'
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
  );
}


