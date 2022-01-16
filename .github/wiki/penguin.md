![](https://github.com/Mos-Origins/GroundedOrigins/blob/fabric/1.18.1/.github/assets/penguin_icon_large.png?raw=true)


***


# **Description/Overview**
_A group of little furry birds that enjoy the ice, snow, and the murder of fish!_


***


# **Happy Feet**
_"You're a 0.25 blocks shorter than a human. Your flightless wings provide more attack speed, but less reach."_

**Ability 1:**
- Scale "height" changed to 0.75 (1.38 blocks high)
- Scale "width" changed to 0.75 (0.45 blocks wide)
- Scale "reach" changed to 0.85
- Scale "motion" changed to 0.9 (all general movement is halved, but it makes sense with the height/width changes above)

**Ability 2:**
- 0.25x more attack speed


***


# **Aquatic Diet**
_"You can only eat seafood, and it sustains you much farther."_

You can only eat food in the `grounded_origins:penguin/seafood` tag (any fish, cooked or uncooked), or in the `origins:ignore_diet` tag


***


# **Aquatic Lunge**
_"Every 10 seconds, you are able to perform an underwater lunge."_

You're able "boost" yourself in the direction you're facing
- Cooldown of 10 seconds
  - **Conditions:**
  - Must be touching water
- **Keys:** Secondary


***


# **Belly Sledding**
_"Your belly is frictionless in colder environments, allowing you to flop onto your belly and slide!"_

You can "slide" (it's swimming, technically) on land
- Cooldown of 7 seconds
- Active for 2 seconds
  - **Conditions:**
  - Must be in biome with temperature less than or equal to 0.4 (any cold/snowy biome)
  - Must be standing on a block
- **Keys:** Primary


***


# **Fragile**
_"You have 3 less hearts of health than humans."_


***


# **Cold Embrace**
_"You're quite resistant in snowy biomes, but weaker and slower the warmer the biome. 4-8 levels of Fire Protecion will grant you safe passage through any biome."_

You gain varying buffs/de-buffs. Buffs in colder biomes, de-buffs in warmer biomes.
- You must be in the biome for 10 seconds to get the effects
- Duration can stack up to a minute

Resistance II:
- **Conditions:**
- Must be in a biome with a temperature less than or equal to 0.05 (Snowy biomes)

Resistance I:
- **Conditions:**
- Must be in a biome with a temperature less than or equal to 0.4 (Cold biomes, like Taigas & Mountains)

Weakness I & Slowness I:
- **Conditions:**
- Must be in a biome with a temperature greater than or equal to 0.6 (Forests, Beaches, Plains, etc.)
- Must _NOT_ be wearing Fire Protection levels greater than or equal to 4

Weakness II & Slowness II:
- **Conditions:**
- Must be in a biome with a temperature greater than or equal to 0.9 (Desert, Badlands, Savannah, Jungle, The Nether, etc.)
- Must _NOT_ be wearing Fire Protection levels greater than or equal to 8


***


# **Fish Hunter**
_"You have an exceptionally high oxygen capacity, and deal far more damage while underwater."_

While underwater:
- You have a flickering Water Breathing effect
- You deal 6 more damage


***


# **Fuzzy Fur**
_"The Nether sets your fur aflame, unless wearing eight levels total of Fire Protection armor. You take double the damage from fire-based sources, unless wearing four levels of Fire Protection."_

**Ability 1:**
You're set on fire when in The Nether dimension
- **Conditions:**
- Must _NOT_ be wearing Fire Protection levels greater than or equal to 8

**Ability 2:**
You take 2x more damage from:
- Lava
- Being on fire
- Being in fire
- Standing on a hot floor (Magma block)
  - **Conditions:**
  - Must _NOT_ be wearing Fire Protection levels greater than or equal to 4


***


# **Webbed Feet**
_"You can swim much faster and take less damage from a fall, but move slower when not in a very cold biome. Alternatively, you can equip Frost Walker boots to maintain the same speed regardless of biome."_

**Ability 1:**
- Swim speed is doubled

**Ability 2:**
- You take 0.4x less fall damage

**Ability 3**
- 0.02 less movement speed (default is 0.1)
  - **Conditions:**
  - Biome temperature must _NOT_ be less than or equal to 0.4
  - Frost Walker enchantment must _NOT_ be equipped