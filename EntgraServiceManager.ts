import { NativeModules } from "react-native"
const { EntgraServiceManager } = NativeModules;
interface IEntgraServiceManager {
    getDeviceAttributes(
        successCallback: (res: any)
            => void,
        errorCallback: (error: any)
            => void,
    ): void;
    getDeviceId(
        successCallback: (res: any)
            => void,
        errorCallback: (error: any)
            => void,
    ): void;
}
export default EntgraServiceManager as IEntgraServiceManager;