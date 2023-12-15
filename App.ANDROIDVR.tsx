import React, { useEffect, useRef } from 'react';
import { Button, Dimensions, UIManager, View, useWindowDimensions } from 'react-native';
import { VideoVR } from './VideoVR';
import { StatusBar } from 'react-native';
import Svg, { Circle, Rect, Line, Path } from 'react-native-svg';
export default function App() {
  const { height, width } = useWindowDimensions();
  console.log({ width, height })
  return (
    <View style={{ flex: 1, backgroundColor: '#000', }}>
      <StatusBar hidden />
      <View style={{ justifyContent: 'space-between', flexDirection: 'row', position: 'absolute' }}>
        <Glasses width={height - 20} thickness={60} />
      </View>


    </View >
  );
}
const Glasses = ({ fill = "pink", width = 100, thickness = 20 }) => {
  const OXY = width / 2
  const RADIUS = width / 2 + thickness
  return (
    <Svg height={`${width + thickness}`} width={`${width + thickness}`} style={{ overflow: 'hidden' }}>
      <Rect x="0" y="0" width={`${width}`} height={`${width}`} fill="none" stroke={fill} strokeWidth={`${thickness}`} />
      {/* <Circle cx={`${RADIUS - 10}`} cy={`${RADIUS - 10}`} r={`${RADIUS - 10}`} fill="none" stroke={'red'} strokeWidth={`${5}`} /> */}
      <Circle cx={`${OXY}`} cy={`${OXY}`} r={`${180}`} fill="none" stroke={fill} strokeWidth={`${100}`} />
    </Svg>
  )
}
{/* <VideoVR
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
        /> */}