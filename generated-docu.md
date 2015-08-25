# Generated documentation 


## Bridges

|Bridge Type Id|Channel Groups|Channels|Description|
|---|---|---|---|
|<a name="bridge-id-bridge"></a>bridge|||The Bosch Thermotechnology Bridge discovers things on a HVAC system.|


## Configuration for bridge: bridge

|Name|Type|Properties|Context|Description|
|---|---|---|---|---|
|login|TEXT|required=true, readOnly=false |default|                     The Gateway Loginname (printed on the label of the gateway).                 |
|gatewayPassword|TEXT|required=true, readOnly=false |password|                     The Gateway Password (printed on the label of the gateway).                 |


## Channels

|Channel Type Id|Item Type|ReadOnly|Options|Description|
|---|---|---|---|---|
|<a name="channel-id-operationMode"></a>operationMode|String|No|Auto mode, Manual mode |The current operation mode.|
|<a name="channel-id-manualTemperatureSetpoint"></a>manualTemperatureSetpoint|Number|No||The room temperature setpoint in manual mode.|
|<a name="channel-id-currentRoomSetpoint"></a>currentRoomSetpoint|Number|No||The room temperature setpoint until next program step.|
|<a name="channel-id-currentRoomTemperature"></a>currentRoomTemperature|Number|Yes||The current measured room temperature.|
|<a name="channel-id-currentOutdoorTemperature"></a>currentOutdoorTemperature|Number|Yes||The current outdoor temperature.|
|<a name="channel-id-comfort2TemperatureSetpoint"></a>comfort2TemperatureSetpoint|Number|No||The room temperature on heating phase.|
|<a name="channel-id-ecoTemperatureSetpoint"></a>ecoTemperatureSetpoint|Number|No||The room temperature on lowering phase.|
|<a name="channel-id-actualModulation"></a>actualModulation|Number|Yes||The current heating modulation.|
|<a name="channel-id-temperatureLevel"></a>temperatureLevel|Number|No||The Water temperature for level high.|
|<a name="channel-id-load"></a>load|Switch|No||Heat up to high level temperature once.|
|<a name="channel-id-currentTemperature"></a>currentTemperature|Number|Yes||The current hot water temperature.|
|<a name="channel-id-yield"></a>yield|Number|Yes||The cumulative yield of solar system for one day in kWh.|
|<a name="channel-id-collectorTemperature"></a>collectorTemperature|Number|Yes||The current solar collector temperature.|
|<a name="channel-id-tankTemperature"></a>tankTemperature|Number|Yes||The current solar tank temperature.|
|<a name="channel-id-pumpModulation"></a>pumpModulation|Number|Yes||The current pump modulation in percent.|
|<a name="channel-id-errorMessage"></a>errorMessage|String|Yes||The error messages.|
|<a name="channel-id-errorDisplayCode"></a>errorDisplayCode|String|Yes||The error display code (dcd).|
|<a name="channel-id-errorCauseCode"></a>errorCauseCode|String|Yes||The error cause code (ccd).|
|<a name="channel-id-maintenanceMessage"></a>maintenanceMessage|String|Yes||The maintenance messages.|
|<a name="channel-id-maintenanceDisplayCode"></a>maintenanceDisplayCode|String|Yes||The maintenance display code (dcd).|
|<a name="channel-id-maintenanceCauseCode"></a>maintenanceCauseCode|String|Yes||The maintenance cause code (ccd).|
|<a name="channel-id-dateTime"></a>dateTime|DateTime|No||The current time of KNX bus.|


## Things

|Thing Type Id|Channel Groups|Config|Description|
|---|---|---|---|
|heating|||The heating subsystem.|
|dhw|||The domestic hot water system.|
|solar|||The Solar system|
|notifications|||The warning and notification service.|
|system|||Device for handling system data.|




## Channel Groups

|Channel Group Type Id|Channels|Description|
|---|---|---|


## Config descriptions

