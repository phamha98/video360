import { StyleSheet, Text, View, Dimensions, StatusBar } from 'react-native'
import React, { useEffect } from 'react'
import { Video360 } from './Video360';
const { width, height } = Dimensions.get('screen')
export default function App() {
  return (
    <View style={styles.f}>
      <StatusBar hidden />
      <View style={{ width: width, height: height }}>
        <Video360
          urlVideo='https://cdn.bitmovin.com/content/assets/playhouse-vr/progressive.mp4'
          modeVideo={2}
          style={{ flex: 1 }}
          volume={0}
          controls={false}


        />
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  f: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'white'
  }
}) 