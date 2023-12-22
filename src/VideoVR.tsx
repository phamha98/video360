import React from 'react';
import { Platform, requireNativeComponent, ViewProps } from 'react-native';
interface Video360Props {
	urlVideo: string
	modeVideo: 1 | 2 | 3
	style: ViewProps['style']
	volume: number
	displayMode: 'embedded' | 'fullscreen' | 'cardboard'
	enableInfoButton: boolean
	enableFullscreenButton: boolean
	enableCardboardButton: boolean
	enableTouchTracking: boolean
	hidesTransitionView: boolean
	onLoadSuccess: (e: any) => any
	onLoadError: (e: any) => any
	onNewFrame: (e: any) => any
	onCompletion: (e: any) => any

}
export const VideoVR = requireNativeComponent<Video360Props>("RCTVideoVR");

