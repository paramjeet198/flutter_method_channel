import 'package:flutter/services.dart';

class BatteryService {
  static const channelName = 'battery_channel';
  static const method = 'getBatteryLevel';

  final _channel = const MethodChannel(channelName);

  Future<String> getBatteryStatus() async {
    try {
      final level = await _channel.invokeMethod(method);
      return '$level%';
    } on PlatformException catch (e) {
      return 'failed to get battery level: ${e.message}';
    }
  }
}
