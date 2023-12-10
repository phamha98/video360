import React, { useEffect, useRef } from 'react';
import { Button, Dimensions, UIManager, View, findNodeHandle } from 'react-native';
import { VideoVR } from './VideoVR';
const { width, height } = Dimensions.get('screen')

export default function App() {
  const refVideo = useRef<any>()
  const loadNative = async () => {


  }

  return (
    <View style={{ flex: 1, backgroundColor: 'red', justifyContent: 'center', alignItems: 'center' }}>
      <Button title='loadNative' onPress={loadNative} />
      <View style={{ width, height: 300, }}>
        <VideoVR
          ref={refVideo}
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
