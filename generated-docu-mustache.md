---
layout: documentation
---

{% include base.html %}

# Astro Binding Binding - Gerhard Riegler

The Astro binding calculates astronomical data from sun and moon.

_If possible, provide some resources like pictures, a YouTube video, etc. to give an impression of what can be done
with this binding. You can place such resources into a `doc` folder next to this README.md._

## Supported Things

_Please describe the different supported things / devices within this section._
_Which different types are supported, which models were tested etc.?_

## Things
|Thing Type Id|Channels|Channel Groups|Config|Description|
|---|---|---|---|
<a name="thing-id-moon"></a>moon ||  [rise (moonRange)](#channel-group-id-moonRange),   [set (moonRange)](#channel-group-id-moonRange),   [phase (moonPhase)](#channel-group-id-moonPhase),   [eclipse (moonEclipse)](#channel-group-id-moonEclipse),   [distance (distance)](#channel-group-id-distance),   [perigee (distance)](#channel-group-id-distance),   [apogee (distance)](#channel-group-id-distance),   [position (position)](#channel-group-id-position),   [zodiac (moonZodiac)](#channel-group-id-moonZodiac)  | | Provides astronomical data from the moon
<a name="thing-id-sun"></a>sun ||  [rise (sunRange)](#channel-group-id-sunRange),   [set (sunRange)](#channel-group-id-sunRange),   [noon (sunRange)](#channel-group-id-sunRange),   [night (sunRange)](#channel-group-id-sunRange),   [morningNight (sunRange)](#channel-group-id-sunRange),   [astroDawn (sunRange)](#channel-group-id-sunRange),   [nauticDawn (sunRange)](#channel-group-id-sunRange),   [civilDawn (sunRange)](#channel-group-id-sunRange),   [astroDusk (sunRange)](#channel-group-id-sunRange),   [nauticDusk (sunRange)](#channel-group-id-sunRange),   [civilDusk (sunRange)](#channel-group-id-sunRange),   [eveningNight (sunRange)](#channel-group-id-sunRange),   [daylight (sunRange)](#channel-group-id-sunRange),   [position (position)](#channel-group-id-position),   [zodiac (sunZodiac)](#channel-group-id-sunZodiac),   [season (season)](#channel-group-id-season),   [eclipse (sunEclipse)](#channel-group-id-sunEclipse)  | | Provides astronomical data from the sun



## Discovery

_Describe the available auto-discovery features here. Mention for what it works and what needs to be kept in mind
when using it._

## Binding Configuration

## Configurations

## <a name="config-desc-thing-type:astro:config"></a> thing-type:astro:config
|Name|Type|Properties|Context|Description|
|---|---|---|---|---|
|geolocation | TEXT | required=false, readOnly=false |  | The latitude and longitude separated with a comma (xx.xxxxxx,xx.xxxxxx) |
|interval | INTEGER | required=false, readOnly=false, max=86400, min=1 |  | Refresh interval for positional data calculation in seconds. |



_If your binding does not offer any generic configurations, you can remove this section completely._

## Thing Configuration

_Describe what is needed to manually configure a thing, either through the (Paper) UI or via a thing-file. This
should be mainly about its mandatory and optional configuration parameters. A short example entry for a thing file
can help!_

## Thing Config


## Bridges
|Bridge Type Id|Channel Groups|Channels|Description|
|---|---|---|---|
|<a name="bridge-id-bridge"></a>bridge |  |   [free_mem](#channel-id-free_mem),    [duty_cycle](#channel-id-duty_cycle)  | This bridge represents the MAX! Cube LAN gateway.&#10;        


## Bridge Config

### bridge
|Name|Type|Properties|Context|Description|
|---|---|---|---|---|
|ipAddress | TEXT | required=false, readOnly=false |  | The IP address of the MAX! Cube LAN gateway&#10;                 |
|port | INTEGER | required=false, readOnly=false, max=65335, min=1 |  | Port of the LAN gateway |
|refreshInterval | INTEGER | required=false, readOnly=false, min=1 |  | The refresh interval in seconds which is used to poll given&#10;                    MAX! Cube.&#10;                 |
|serialNumber | TEXT | required=false, readOnly=false |  | The Serial Number identifies one specific device.&#10;                 |
|rfAddress | TEXT | required=false, readOnly=false |  | The RF Address used for communication between the devices.&#10;                 |
|exclusive | BOOLEAN | required=false, readOnly=false |  | If set to true, the binding will leave the connection&#10;                    to the Cube open.&#10;                 |
|maxRequestsPerConnection | INTEGER | required=false, readOnly=false |  | In exclusive mode, how many requests are allowed until&#10;                    connection is closed and reopened.&#10;                 |




## Channels

_Here you should provide information about available channel types, what their meaning is and how they can be used._

## Channels
|Channel Type Id|Item Type|ReadOnly|Options|Description|
|---|---|---|---|---|
<a name="channel-id-free_mem"></a>free_mem | Number |  Yes    |    | Free memory slots to store commands send to the devices&#10;        
<a name="channel-id-duty_cycle"></a>duty_cycle | Number |  Yes    |    | Duty Cycle for sending commands to the devices&#10;        
<a name="channel-id-azimuth"></a>azimuth | Number |  Yes    |    | The azimuth of the planet
<a name="channel-id-elevation"></a>elevation | Number |  Yes    |    | The elevation of the planet
<a name="channel-id-start"></a>start | DateTime |  Yes    |    | The start time of the event
<a name="channel-id-end"></a>end | DateTime |  Yes    |    | The end time of the event
<a name="channel-id-duration"></a>duration | Number |  Yes    |    | The duration time in minutes of the event
<a name="channel-id-sign"></a>sign | String |  Yes    |  Aries, Taurus, Gemini, Cancer, Leo, Virgo, Libra, Scorpio, Sagittarius, Capricorn, Aquarius, Pisces  | The sign of the zodiac
<a name="channel-id-seasonName"></a>seasonName | String |  Yes    |  Spring, Summer, Autumn, Winter  | The name of the current season
<a name="channel-id-spring"></a>spring | DateTime |  Yes    |    | The beginning of spring
<a name="channel-id-summer"></a>summer | DateTime |  Yes    |    | The beginning of summer
<a name="channel-id-autumn"></a>autumn | DateTime |  Yes    |    | The beginning of autumn
<a name="channel-id-winter"></a>winter | DateTime |  Yes    |    | The beginning of winter
<a name="channel-id-total"></a>total | DateTime |  Yes    |    | The DateTime of the next total eclipse
<a name="channel-id-partial"></a>partial | DateTime |  Yes    |    | The DateTime of the next partial eclipse
<a name="channel-id-ring"></a>ring | DateTime |  Yes    |    | The DateTime of the next ring eclipse
<a name="channel-id-firstQuarter"></a>firstQuarter | DateTime |  Yes    |    | The DateTime the moon is in the first quarter
<a name="channel-id-thirdQuarter"></a>thirdQuarter | DateTime |  Yes    |    | The DateTime the moon is in the third quarter
<a name="channel-id-fullMoon"></a>fullMoon | DateTime |  Yes    |    | The DateTime for full moon
<a name="channel-id-newMoon"></a>newMoon | DateTime |  Yes    |    | The DateTime for new moon
<a name="channel-id-age"></a>age | Number |  Yes    |    | The age of the moon in days
<a name="channel-id-illumination"></a>illumination | Number |  Yes    |    | The illumination of the moon in %
<a name="channel-id-phaseName"></a>phaseName | String |  Yes    |  New moon, Waxing crescent, First quarter, Waxing gibbous, Full moon, Wanning gibbous, Third quarter, Waning crescent  | The name of the current moon phase
<a name="channel-id-distanceDate"></a>distanceDate | DateTime |  Yes    |    | The DateTime when the distance is reached
<a name="channel-id-miles"></a>miles | Number |  Yes    |    | The distance in miles
<a name="channel-id-kilometer"></a>kilometer | Number |  Yes    |    | The distance in kilometers


## Channel Groups
|Channel Group Type Id|Channels|Description|
|---|---|---|
<a name="channel-group-id-position"></a>position |   [azimuth](#channel-id-azimuth),    [elevation](#channel-id-elevation)  | The position of the planet
<a name="channel-group-id-sunRange"></a>sunRange |   [start](#channel-id-start),    [end](#channel-id-end),    [duration](#channel-id-duration)  | Range for a sun event
<a name="channel-group-id-moonRange"></a>moonRange |   [start](#channel-id-start),    [end](#channel-id-end)  | Range for a moon event
<a name="channel-group-id-sunZodiac"></a>sunZodiac |   [start](#channel-id-start),    [end](#channel-id-end),    [sign](#channel-id-sign)  | The Zodiac of the sun
<a name="channel-group-id-season"></a>season |   [name](#channel-id-name),    [spring](#channel-id-spring),    [summer](#channel-id-summer),    [autumn](#channel-id-autumn),    [winter](#channel-id-winter)  | The seasons this year
<a name="channel-group-id-sunEclipse"></a>sunEclipse |   [total](#channel-id-total),    [partial](#channel-id-partial),    [ring](#channel-id-ring)  | The DateTime of the next sun eclipses
<a name="channel-group-id-moonPhase"></a>moonPhase |   [firstQuarter](#channel-id-firstQuarter),    [thirdQuarter](#channel-id-thirdQuarter),    [full](#channel-id-full),    [new](#channel-id-new),    [age](#channel-id-age),    [illumination](#channel-id-illumination),    [name](#channel-id-name)  | Moonphases
<a name="channel-group-id-moonEclipse"></a>moonEclipse |   [total](#channel-id-total),    [partial](#channel-id-partial)  | The DateTime of the next moon eclipses
<a name="channel-group-id-distance"></a>distance |   [date](#channel-id-date),    [miles](#channel-id-miles),    [kilometer](#channel-id-kilometer)  | Distance data
<a name="channel-group-id-moonZodiac"></a>moonZodiac |   [sign](#channel-id-sign)  | The Zodiac of the moon


## Full Example

_Provide a full usage example based on textual configuration files (*.things, *.items, *.sitemap)._

## Any custom content here!

_Feel free to add additional sections for whatever you think should also be mentioned about your binding!_
