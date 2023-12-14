import React, { useEffect, useRef } from 'react';
import { Button, Dimensions, UIManager, View, useWindowDimensions } from 'react-native';
import { VideoVR } from './VideoVR';
import { StatusBar } from 'react-native';


export default function App() {
  const { height, width } = useWindowDimensions();
  console.log({ width, height })
  return (
    <View style={{ flex: 1, backgroundColor: '#000', }}>
      <StatusBar hidden />
      <View style={{ width, height: height - 10 }}>
        <VideoVR
          urlVideo='https://cdn.bitmovin.com/content/assets/playhouse-vr/progressive.mp4'
          modeVideo={3}
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
      </View>

    </View>
  );
}
