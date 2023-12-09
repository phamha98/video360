/**
 * @format
 */

import { AppRegistry, Platform } from 'react-native';
import ANDROID from './App.ANDROID';
import IOS from './App.IOS';
import { name as appName } from './app.json';

AppRegistry.registerComponent(appName, () => Platform.select({
    android: ANDROID,
    ios: IOS
}));
