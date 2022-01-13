![](https://github.com/Mos-Origins/GroundedOrigins/blob/master/.github/assets/moth_icon_large.png?raw=true)


***

# **Description/Overview**
_Small, fuzzy, flying insects with an odd appetite for natural fibers and an infatuation with lamps and lights._


***


# **Vegetarian**
_"You can't digest any meat."_

- You're prevented from consuming anything food inside the `origins:meat` tag (any meat food)
    - **Conditions:**
    - Food item _**NOT**_ in `origins:ignore_diet` tag


***


# **Insect**
_"You are 4 times smaller than a regular human. You have 25% less attack/build range. You have 4 hearts, but your body is incredbily light, allowing you take a fall or collision from any height"_

**Ability 1:**
- Scale "height" changed to 0.26 (0.47 blocks high)
- Scale "width" changed to 0.26 (0.17 blocks wide)
- Scale "motion" changed to 0.5 (all general movement is halved, but it makes sense with the two scale changes above)
- Scale "reach" changed to 0.75
- Scale "step_height" changed to 2 (this makes it so that slabs/stairs still function the same)
- Scale "view_bobbing" changed to 1.5

**Ability 2:**
- You have 4 hearts

**Ability 3:**
- Fall damage immunity
- Elytra collision damage immunity


***


# **Winged**
_"You're capable of flight, but chest-plates cover up your wings entirely."_

- You always have Elytra wings & flight
  - **Conditions:**
  - Must _NOT_ be wearing anything in chest armor slot


***


# **Flutter**
_"Every 25 seconds, you are able to launch yourself 10-20 blocks upwards."_

- You can launch yourself upwards
- 25 second cooldown
- **Key:** Primary


***


# **Pollenator**
_"Having 15 flowers within 20 blocks will boost your health by two hearts and allow you to bonemeal the block you're looking at, as long as you aren't exposed to sunlight. Flower forests make you stronger."_

**Ability 1:**
- You get 4 more health (2 hearts)
  - **Conditions:**
  - Must have 15 blocks in `minecraft:flowers` tag within 20-block radius

**Ability 2:**
- You can bonemeal the block you're standing on or in
- Cooldown of 2 seconds
  - **Conditions:**
  - Must have 15 blocks in `minecraft:flowers` tag within 20-block radius
  - Must _NOT_ be exposed to sunlight
- **Key:** 

**Ability 3:**
- You gain Strength I when in a Flower Forest
- Stacks up to 2:30 mins


***


# **Four Arms**
_"You are able to climb vertical surfaces."_

- You can climb any surface
- **Key:** Ternary (toggle on/off)


***


# **Water Vulnerability**
_"You recieve damage over time while in water. Contact with water slows you down significantly due to your fluff and disables your flight. You can negate these effects using Water Protection enchantments."_

**Ability 1:**
- You recieve damage over time while touching water
- You take 2 damage (1 damage if on easy mode)
- You're protected by Water Protection enchantments

**Ability 2:**
- You gain Slowness III while in rain
  - **Conditions:**
  - Must _NOT_ have Water Protection level greater than or equal to 4

**Ability 3:**
- You're significantly slower underwater
  - **Conditions:**
  - Must _NOT_ have Water Protection level greater than or equal to 4


***


# **Flammable**
_"Your fluff causes you to take 50% more damage from heat-based sources."_

You take 0.5x more damage from:
- Lava
- Being on fire
- Being in fire


***


# **Phototactic**
_"Your infatuation with light has led you to evolve varied effects when around Lanterns, Glowstone, Soul-lights, Sea Lanterns, and Pumpkin-lights for a long period of time, as long as you aren't in sunlight."_

You can gain varying buffs around different light sources. The buffs can stack up to 1 minute in duration.
- **Conditions:**
- You must be in a radius of 15 blocks from a light source
- You must be in that radius for 15 seconds
- You must _NOT_ be exposed to sunlight

**Lanterns:**
- Regeneration I
- Block must be in `grounded_origins:moth/lanterns` tag
- (Lanterns & Redstone Lamps)

**Glowstone:**
- Slow Falling
- Block must be in `grounded_origins:moth/glowstone_lights` tag
- (Glowstone, Shroomlight)

**Pumpkins:**
- Resistance I
- Block must be in `grounded_origins:moth/pumpkin_lights` tag
- (Jack O' Lantern)

**Soul Lights:**
- Haste I
- Block must be in `grounded_origins:moth/soul_lights` tag
- (Soul Lantern, Soul Torch, Soul Campfire)

**Sea Lanterns:**
- Dolphins Grace
- Block must be in `grounded_origins:moth/sea_lights` tag
- (Sea Lanterns)


***


# **Nocturnal**
_"Your vision is adapted to dark spaces, but you feel weaker when exposed to the sun."_

**Ability 1:**
- Toggle-able Night Vision
- **Key:** Secondary

**Ability 2:**
- You get Weakness I
- Can stay for up to 3 minutes
  - **Conditions:**
  - Must be exposed to sunlight for over 10 seconds


***


# **Fibrous Diet**
_"You're able to eat wool, leather, paper, and books."_

- You can eat items in the `grounded_origins:moth/edible` tag (Wool, Leather, Paper, and Books)
- You gain 4 food shanks (8 food total)
- You gain almost a full bar of saturation
