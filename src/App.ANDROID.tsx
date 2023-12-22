import React, { useEffect, useRef } from 'react';
import { Button, Dimensions, UIManager, View, findNodeHandle } from 'react-native';
import { Video360 } from './Video360';
// import Video360 from './Video480';
const videoUrl = 'https://adowindow.com/wp-content/uploads/video360.mp4?fbclid=IwAR2ptsOxD5tW1SkL668GmroGvZQzgIJDLAcYfsPkltx8O9oWZcYUnrrKPVY'
const { width, height } = Dimensions.get('screen')

export default function App() {

  return (
    <View style={{ flex: 1, backgroundColor: 'red', justifyContent: 'center', alignItems: 'center' }}>
      <View style={{ width, height: 300, }}>
        <Video360
          urlVideo='https://adowindow.com/wp-content/uploads/video360.mp4'
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
