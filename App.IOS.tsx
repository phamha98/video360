import { StyleSheet, Text, View, Dimensions } from 'react-native'
import React, { useEffect } from 'react'
import { Video360 } from './Video360';
const { width, height } = Dimensions.get('screen')
export default function App() {
  return (
    <View style={styles.f}>
      <View style={{ width: width, height: height }}>
        <Video360
          urlVideo='https://cdn.bitmovin.com/content/assets/playhouse-vr/progressive.mp4'
          modeVideo={1}
          style={{ flex: 1 }}
          volume={1}

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
// const checkPermission = async () => {

//   request(PERMISSIONS.IOS.MOTION)
//     .then(result => {
//       switch (result) {
//         case RESULTS.UNAVAILABLE:
//           console.log(
//             'This feature is not available (on this device / in this context)',
//           )
//           // openSettings()
//           request(PERMISSIONS.IOS.PHOTO_LIBRARY)
//           break
//         case RESULTS.DENIED:
//           console.log(
//             'The permission has not been requested / is denied but requestable',
//           )

//           break
//         case RESULTS.GRANTED:
//           console.log('The permission is granted')
//           break
//         case RESULTS.BLOCKED:
//           openSettings()
//           console.log('The permission is denied and not requestable anymore')
//           break
//       }
//     })
//     .catch(error => {
//       // …
//     })
// }

// const checkPermission2 = async () => {
//   console.log('checkPermission2')
//   request(PERMISSIONS.IOS.MICROPHONE)
//     .then(result => {
//       switch (result) {
//         case RESULTS.UNAVAILABLE:
//           console.log(
//             'This feature is not available (on this device / in this context)',
//           )
//           // openSettings()
//           request(PERMISSIONS.IOS.PHOTO_LIBRARY)
//           break
//         case RESULTS.DENIED:
//           console.log(
//             'The permission has not been requested / is denied but requestable',
//           )

//           break
//         case RESULTS.GRANTED:
//           console.log('The permission is granted')
//           break
//         case RESULTS.BLOCKED:
//           openSettings()
//           console.log('The permission is denied and not requestable anymore')
//           break
//       }
//     })
//     .catch(error => {
//       // …
//     })
// }