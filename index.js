/**
 * @format
 */

import { AppRegistry, Platform } from 'react-native';
import ANDROID from './src/App.ANDROIDVR';
import IOS from './src/App.IOS';
import { name as appName } from './app.json';

AppRegistry.registerComponent(appName, () => Platform.select({
    android: ANDROID,
    ios: IOS
}));
