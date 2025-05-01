import 'package:flutter/material.dart';
import 'package:flutter_method_channel/service/battery_service.dart';

class BatteryWidget extends StatelessWidget {
  BatteryWidget({super.key});

  final batteryService = BatteryService();

  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
      future: batteryService.getBatteryStatus(),
      builder: (context, snapshot) {
        return Text(snapshot.data ?? 'Loading battery level...');
      },
    );
  }
 ///



}
