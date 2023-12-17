import React, { useEffect, useRef } from 'react';
import { Button, Dimensions, Image, View, useWindowDimensions, SafeAreaView } from 'react-native';
import { VideoVR } from './VideoVR';
import { StatusBar } from 'react-native';
import Svg, { Circle, Rect, Line, Path, Defs } from 'react-native-svg';
import SvgUri from 'react-native-svg-uri';

export default function App() {
  const { height, width } = Dimensions.get('screen')
  console.log({ width, height })
  const heightset = height - 30
  const bg1 = "#000"
  const wX = heightset * 0.8
  const w3 = wX * 0.15
  const h1 = (heightset - wX) / 2
  const w1 = (width - wX * 2 - w3) / 2
  return (
    <SafeAreaView
      style={[
        {
          flex: 1,
        },

      ]}
    >
      <View style={{ flex: 1, backgroundColor: '#8000FF', }}>
        <StatusBar hidden />
        <VideoVR
          urlVideo='https://cdn.bitmovin.com/content/assets/playhouse-vr/progressive.mp4'
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
  );
}


