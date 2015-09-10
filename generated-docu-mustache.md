---
layout: documentation
---

{% include base.html %}

# Plugwise Anna Binding Binding - Plugwise B.V.

This is the binding for Plugwise Anna devices.

_If possible, provide some resources like pictures, a YouTube video, etc. to give an impression of what can be done
with this binding. You can place such resources into a `doc` folder next to this README.md._

## Supported Things

_Please describe the different supported things / devices within this section._
_Which different types are supported, which models were tested etc.?_

<table>
<thead>
<th>Thing Type Id</th>
<th>Channels</th>
<th>Channel Groups</th>
<th>Config</th>
<th>Description</th>
</thead>
<tbody>
<tr>
<td><a name="thing-id-thermostat"></a>thermostat</td>
<td>  <a href="#channel-id-roomSetpoint">roomSetpoint</a>,    <a href="#channel-id-heatingMode">heatingMode</a>,    <a href="#channel-id-currentRoomTemperature">currentRoomTemperature</a>,    <a href="#channel-id-schedule">schedule</a> </td>
<td></td>
<td></td>
<td>An anna thermostat.</td>
</tr>
<tr>
<td><a name="thing-id-boiler"></a>boiler</td>
<td></td>
<td></td>
<td></td>
<td>A central heating boiler</td>
</tr>
</tbody>
</table>

## Discovery

_Describe the available auto-discovery features here. Mention for what it works and what needs to be kept in mind
when using it._

## Binding Configuration




_If your binding does not offer any generic configurations, you can remove this section completely._

## Thing Configuration

_Describe what is needed to manually configure a thing, either through the (Paper) UI or via a thing-file. This
should be mainly about its mandatory and optional configuration parameters. A short example entry for a thing file
can help!_

## Thing Config


## Bridges
|Bridge Type Id|Channel Groups|Channels|Description|
|---|---|---|---|
|<a name="bridge-id-bridge"></a>bridge |  |  | The plugwise smile device to connect anna and tom devices.


## Bridge Config

### bridge
|Name|Type|Properties|Context|Description|
|---|---|---|---|---|
|id | TEXT | required=true, readOnly=false |  | &#10;                    The Short-ID for smile.&#10;                 |
|pollingInterval | INTEGER | required=false, readOnly=false, max=300, min=15 |  | &#10;                    The refresh interval for all values.&#10;                 |




## Channels

_Here you should provide information about available channel types, what their meaning is and how they can be used._

|Channel Type Id|Item Type|ReadOnly|Options|Description|
|---|---|---|---|---|
<a name="channel-id-roomSetpoint"></a>roomSetpoint | Number |   No   |    | The room temperature setpoint.
<a name="channel-id-heatingMode"></a>heatingMode | String |   No   |  Comfort, Eco, Super eco  | The current anna operation mode.
<a name="channel-id-currentRoomTemperature"></a>currentRoomTemperature | Number |  Yes    |    | The current measured room temperature.
<a name="channel-id-schedule"></a>schedule | String |   No   |    | The current weekly schedule in JSON format.




## Full Example

_Provide a full usage example based on textual configuration files (*.things, *.items, *.sitemap)._

## Any custom content here!

_Feel free to add additional sections for whatever you think should also be mentioned about your binding!_
