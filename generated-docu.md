# Generated documentation 


## Bridges

|Bridge Type Id|Channel Groups|Channels|Description|
|---|---|---|---|
|<a name="bridge-id-bridge"></a>bridge||[free_mem](#channel-id-free_mem), [duty_cycle](#channel-id-duty_cycle) |This bridge represents the MAX! Cube LAN gateway.         |


## Configuration for bridge: bridge

|Name|Type|Properties|Context|Description|
|---|---|---|---|---|
|ipAddress|TEXT|required=false, readOnly=false |network-address|The IP address of the MAX! Cube LAN gateway                 |
|port|INTEGER|required=false, readOnly=false, max=65335, min=1 |network-address|Port of the LAN gateway|
|refreshInterval|INTEGER|required=false, readOnly=false, min=1 |default|The refresh interval in seconds which is used to poll given                     MAX! Cube.                 |
|serialNumber|TEXT|required=false, readOnly=false |default|The Serial Number identifies one specific device.                 |
|rfAddress|TEXT|required=false, readOnly=false |default|The RF Address used for communication between the devices.                 |
|exclusive|BOOLEAN|required=false, readOnly=false |default|If set to true, the binding will leave the connection                     to the Cube open.                 |
|maxRequestsPerConnection|INTEGER|required=false, readOnly=false |default|In exclusive mode, how many requests are allowed until                     connection is closed and reopened.                 |


## Channels

|Channel Type Id|Item Type|ReadOnly|Options|Description|
|---|---|---|---|---|
|<a name="channel-id-azimuth"></a>azimuth|Number|Yes||The azimuth of the planet|
|<a name="channel-id-elevation"></a>elevation|Number|Yes||The elevation of the planet|
|<a name="channel-id-start"></a>start|DateTime|Yes||The start time of the event|
|<a name="channel-id-end"></a>end|DateTime|Yes||The end time of the event|
|<a name="channel-id-duration"></a>duration|Number|Yes||The duration time in minutes of the event|
|<a name="channel-id-sign"></a>sign|String|Yes|Aries, Taurus, Gemini, Cancer, Leo, Virgo, Libra, Scorpio, Sagittarius, Capricorn, Aquarius, Pisces |The sign of the zodiac|
|<a name="channel-id-seasonName"></a>seasonName|String|Yes|Spring, Summer, Autumn, Winter |The name of the current season|
|<a name="channel-id-spring"></a>spring|DateTime|Yes||The beginning of spring|
|<a name="channel-id-summer"></a>summer|DateTime|Yes||The beginning of summer|
|<a name="channel-id-autumn"></a>autumn|DateTime|Yes||The beginning of autumn|
|<a name="channel-id-winter"></a>winter|DateTime|Yes||The beginning of winter|
|<a name="channel-id-total"></a>total|DateTime|Yes||The DateTime of the next total eclipse|
|<a name="channel-id-partial"></a>partial|DateTime|Yes||The DateTime of the next partial eclipse|
|<a name="channel-id-ring"></a>ring|DateTime|Yes||The DateTime of the next ring eclipse|
|<a name="channel-id-firstQuarter"></a>firstQuarter|DateTime|Yes||The DateTime the moon is in the first quarter|
|<a name="channel-id-thirdQuarter"></a>thirdQuarter|DateTime|Yes||The DateTime the moon is in the third quarter|
|<a name="channel-id-fullMoon"></a>fullMoon|DateTime|Yes||The DateTime for full moon|
|<a name="channel-id-newMoon"></a>newMoon|DateTime|Yes||The DateTime for new moon|
|<a name="channel-id-age"></a>age|Number|Yes||The age of the moon in days|
|<a name="channel-id-illumination"></a>illumination|Number|Yes||The illumination of the moon in %|
|<a name="channel-id-phaseName"></a>phaseName|String|Yes|New moon, Waxing crescent, First quarter, Waxing gibbous, Full moon, Wanning gibbous, Third quarter, Waning crescent |The name of the current moon phase|
|<a name="channel-id-distanceDate"></a>distanceDate|DateTime|Yes||The DateTime when the distance is reached|
|<a name="channel-id-miles"></a>miles|Number|Yes||The distance in miles|
|<a name="channel-id-kilometer"></a>kilometer|Number|Yes||The distance in kilometers|
|<a name="channel-id-free_mem"></a>free_mem|Number|Yes||Free memory slots to store commands send to the devices         |
|<a name="channel-id-duty_cycle"></a>duty_cycle|Number|Yes||Duty Cycle for sending commands to the devices         |


## Things

|Thing Type Id|Channel Groups|Config|Description|
|---|---|---|---|
|moon|[rise](#channel-group-id-moonRange), [set](#channel-group-id-moonRange), [phase](#channel-group-id-moonPhase), [eclipse](#channel-group-id-moonEclipse), [distance](#channel-group-id-distance), [perigee](#channel-group-id-distance), [apogee](#channel-group-id-distance), [position](#channel-group-id-position), [zodiac](#channel-group-id-moonZodiac) |[#config-desc-thing-type:astro:config](#config-desc-thing-type:astro:config)|Provides astronomical data from the moon|
|sun|[rise](#channel-group-id-sunRange), [set](#channel-group-id-sunRange), [noon](#channel-group-id-sunRange), [night](#channel-group-id-sunRange), [morningNight](#channel-group-id-sunRange), [astroDawn](#channel-group-id-sunRange), [nauticDawn](#channel-group-id-sunRange), [civilDawn](#channel-group-id-sunRange), [astroDusk](#channel-group-id-sunRange), [nauticDusk](#channel-group-id-sunRange), [civilDusk](#channel-group-id-sunRange), [eveningNight](#channel-group-id-sunRange), [daylight](#channel-group-id-sunRange), [position](#channel-group-id-position), [zodiac](#channel-group-id-sunZodiac), [season](#channel-group-id-season), [eclipse](#channel-group-id-sunEclipse) |[#config-desc-thing-type:astro:config](#config-desc-thing-type:astro:config)|Provides astronomical data from the sun|




## Channel Groups

|Channel Group Type Id|Channels|Description|
|---|---|---|
|<a name="channel-group-id-position"></a>position|[azimuth](#channel-id-azimuth), [elevation](#channel-id-elevation) |The position of the planet|
|<a name="channel-group-id-sunRange"></a>sunRange|[start](#channel-id-start), [end](#channel-id-end), [duration](#channel-id-duration) |Range for a sun event|
|<a name="channel-group-id-moonRange"></a>moonRange|[start](#channel-id-start), [end](#channel-id-end) |Range for a moon event|
|<a name="channel-group-id-sunZodiac"></a>sunZodiac|[start](#channel-id-start), [end](#channel-id-end), [sign](#channel-id-sign) |The Zodiac of the sun|
|<a name="channel-group-id-season"></a>season|[name](#channel-id-seasonName), [spring](#channel-id-spring), [summer](#channel-id-summer), [autumn](#channel-id-autumn), [winter](#channel-id-winter) |The seasons this year|
|<a name="channel-group-id-sunEclipse"></a>sunEclipse|[total](#channel-id-total), [partial](#channel-id-partial), [ring](#channel-id-ring) |The DateTime of the next sun eclipses|
|<a name="channel-group-id-moonPhase"></a>moonPhase|[firstQuarter](#channel-id-firstQuarter), [thirdQuarter](#channel-id-thirdQuarter), [full](#channel-id-fullMoon), [new](#channel-id-newMoon), [age](#channel-id-age), [illumination](#channel-id-illumination), [name](#channel-id-phaseName) |Moonphases|
|<a name="channel-group-id-moonEclipse"></a>moonEclipse|[total](#channel-id-total), [partial](#channel-id-partial) |The DateTime of the next moon eclipses|
|<a name="channel-group-id-distance"></a>distance|[date](#channel-id-distanceDate), [miles](#channel-id-miles), [kilometer](#channel-id-kilometer) |Distance data|
|<a name="channel-group-id-moonZodiac"></a>moonZodiac|[sign](#channel-id-sign) |The Zodiac of the moon|


## Config descriptions

## thing-type:astro:config<a name="config-desc-thing-type:astro:config"></a> 

|Name|Type|Properties|Context|Description|
|---|---|---|---|---|
|geolocation|TEXT|required=false, readOnly=false |default|The latitude and longitude separated with a comma (xx.xxxxxx,xx.xxxxxx)|
|interval|INTEGER|required=false, readOnly=false, max=86400, min=1 |default|Refresh interval for positional data calculation in seconds.|
