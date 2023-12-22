import { StyleSheet, Text, Image, TouchableOpacity } from 'react-native'
import React from 'react'

export default function ButtonBack({ size = 25, onPress }: any) {
    return (
        <TouchableOpacity
            onPress={onPress}
            style={{ position: 'absolute', top: 10, left: 10, zIndex: 999 }}
        >
            <Image source={require('./back.png')} style={{ width: size, height: size, tintColor: 'white' }} />
        </TouchableOpacity>
    )
}

const styles = StyleSheet.create({})