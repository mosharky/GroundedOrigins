[A MORE READABLE CHANGELOG HERE](https://github.com/Mos-Origins/GroundedOrigins/blob/fabric/1.19/.github/CHANGELOG.md)
# **[1.2.3] - 2022/21/10**
Forge will hopefully receive an update & port to 1.19.2 once Apugli goes multiloader and the Origins Forge port fixes some dependency issues. If anyone cares, I'm too lazy to update the wiki. It probably needs an overhaul anyway.

I'll also look at some mod compat with the Ecologics mod maybe for the future.

### FABRIC:
- Ported to 1.19.2 (technically)
- Updated Apugli from v1.8.2 to v1.9.3
- Changed Moth powers:
  - Phototactic:
    - Buff from Glowstone Lights `grounded_origins:moth/glowstone_lights` to give the Glowing effect instead of the Slow Falling effect
      - Slow Falling can be pretty annoying, thus the change. I'm not sure if there's a better, more beneficial effect I could give. If you have one, be my guest.
  - Nocturnal:
    - Reduced max Weakness duration from 3 mins to 2 mins
    - Increased minimum time required in the sun for weakness from 10 seconds to 1 minute
  - Fibrous Diet:
    - Wool-to-string recipe gives 2 string, up from 1
- Adjusted several origin/power descriptions:
  - Moth: Winged
    - **Before**: *"You're capable of flight, but chestplates cover up your wings entirely."*
    - **After**: *"You're capable of **a soft glide**, but chestplates cover up your wings entirely."*
  - Moth: Nocturnal
    - **Before**: *"Your vision is adapted to dark spaces, but you feel weaker when exposed to the sun."*
    - **After**: *"Your vision is adapted to dark spaces, but you feel weaker when exposed to the sun **for long periods of time."***
  - Beach Crab: Kelpomaniac
    - **Before**: *"You can eat Kelp, and it empowers your underwater vision."*
    - **After**: *"You can eat Kelp, **which** empowers your **underwater vision and oxygen capacity.**"*
  - Penguin (Origin):
    - **Before**: *"A group of little furry birds that enjoy the ice, snow, and the murder of fish!"*
    - **After**: *"**Furry, sea-faring** birds that enjoy the ice, snow, and the murder of fish!"*
  - Penguin: Aquatic Diet
    - **Before**: *"You can only eat seafood, and it sustains you much farther. You don't suffer any negative/positive effects from seafood, and you can hold your breathe for a very long time after eating a Pufferfish."*
    - **After**: *"You can only eat seafood, and it sustains you much farther. You don't suffer any **effects from seafood, and consuming a Pufferfish pumps you full of air.**"*


***


# **[1.2.2] - 2022/07/20**

### FABRIC:
- Updated Apugli from v1.7.2 to v1.8.2
  - Fixes Game crash upon being hit by an arrow/fire charge from a dispenser


***


# **[1.2.1] - 2022/06/30**
Wiki & mod page descriptions will be getting changes & additions soon.

### FABRIC:
Ported to 1.19!


***


# **[1.2.0] - 2022/06/30**
If you want any changes, now would be a good time to let me know! Submit a suggestion in the issues section of the github repo. I might create custom status bar textures for each origin too! Also, sorry Forge folks.

1.19 coming soon :)

### BOTH:
- #### Beach Crab refresh!
  - The Weakness effect from **Home!** for not being in a beach biome now applies after 15 minutes, up from 1 minute
  - Changed **Home!** description: _"Beach biomes provide you with immense strength and fortification. You feel weaker outside of beach biomes if you stay in them for over 15 minutes."_

### FABRIC:
- [Apugli](https://www.curseforge.com/minecraft/mc-mods/apugli) by MerchantPug has been added as a library to Grounded Origins to help with the new changes! (No extra download needed)
- #### Beach Crab refresh!
  - **Crustacean Gills** now applies Respiration 4, instead of relying on a cruddy implementation of "more oxygen" using the Waterbreathing effect, all thanks to Apugli! This can apply on top of a Respiration 3 helmet too!
  - Replaced **Seagrass Appetite** with **Kelpomaniac**:
    - Crabs can now eat Kelp! Except, properly this time.
    - It gives 3 hunger and the Conduit Power effect for 1 minute
    - New description: _"You can eat Kelp, and it empowers your underwater vision."_
- #### Moth food changes!
  - Removed the following food items completely:
    - Fibrous String
    - Book Bite
    - Paper Shreds
  - **Fibrous Diet** changes! Moths now directly eat the following items (instead of having to craft them):
    - String
    - Leather
    - Paper
    - Books
    - New description: _"You can only eat bits of leather, paper, books, string, and other fibrous foods. You can craft one piece of string with a block of wool."_
  - The above foods have been added to `grounded_origins:moth/fibrous_foods`
  - Flower Stamens have remained the same
  - Changed **Nectar Production** description: _"You can drink nectar by consuming Flower Stamens. Nectar is highly nutritious and boosts your health. You can craft Flower Stamens with two flowers."_

### FORGE:
The Forge port will likely not recieve many improvements in the future aside from ports to newer versions due to the lack of Apugli on Forge. Unless that changes, I'll only be adding changes that'll work without Apugli.

- Removed **Seagrass Appetite** power from Beach Crab due to its poor implementation without Apugli.


***


# **[1.1.3] - 2022/04/20**

### FORGE:
- Internal changes to `cube_check` (thanks to [EdwinMindcraft](https://www.curseforge.com/members/edwinmindcraft/projects) for [this pull request](https://github.com/Mos-Origins/GroundedOrigins/pull/6))

### BOTH:
- Updated to 1.18.2
- Updated dependencies
- Changed `penguin/webbed_feet` and `moth/water_vulnerability` to use the `additionalentityattributes:water_speed` instead of the `modify_swim_speed` power-type


***


# **[1.1.2] - 2022/04/10**

### FORGE:
- The Moth origin's Pollinator and Phototactic powers are back, the FPS issue has been fixed!
- Created the `grounded_origins:cube_check` power and entity condition as an optimized alternative to the `origins:block_in_radius` condition
  - All thanks to [EdwinMindcraft](https://www.curseforge.com/members/edwinmindcraft/projects) for working on this in [this pull request](https://github.com/Mos-Origins/GroundedOrigins/pull/4)!
  - You can find documentation on this [here](https://github.com/Mos-Origins/GroundedOrigins/wiki/Power-types-&-Conditions-Documentation)

### BOTH:
- Added Russian localization ([thanks to _vanja-san_!](https://github.com/Mos-Origins/GroundedOrigins/pull/3/commits/710a304c0e976ff78e07fa48a5654644fe33116e))
- The Moth origin's Pollinator and Phototactic buffs can stack up to 2 minutes, up from 1 minute 
- The Moth origin's Flower Forest strength buff from Pollinator is no longer amplified; it's just Strength I now


***


# **[1.1.1] - 2022/04/09**

### FABRIC:
- Refactored `c:tools` item tag to `fabric:tools`

### FORGE:
- **Temporarily disabled the Moth origin's "Pollinator" and "Phototactic" powers.** The two powers cause an insane amount of lag that isn't present on Fabric or the 1.16.5 Forge port of the Origins mod. The Forge port dev told me that he'll try working on a solution, but there are no promises
  - Until the issue is fixed in the Forge port of Origins, these two powers will remain disabled. If that takes too long, I'll try to replace those powers with something new.
  - For now, I wouldn't recommend picking the Moth Origin until this is fixed.

### BOTH:
- Removed unused `grounded_origins:penguin/happy_blocks` tag
- Fixed regen effect not applying properly with Deer's "Forest Native" power
- Pollinator > Pollenator lol
- Forest Native now applies its effects for 10 seconds, up from 5
- Changed Deer's "Springed Step" and "Hooved Grace" power descriptions to be more accurate:
  - **Springed Step:** _"Your natural elasticity allows for a higher jump while galloping."_
  - **Hooved Grace:** _"Your hooves absorb half the trauma of any fall."_


***


# **[1.1.0] - 2022/03/24**

### FABRIC:
- Updated dependencies

### FORGE:
- Ported to 1.18.1
- **Note**: _Keep in mind that some things may not work correctly as the Origins Forge port continues to update_
- Removed Origins Power Expansion dependency

### BOTH:
- Added new foods that can only be crafted with the Moth Origin:
- ![Spritesheet](https://github.com/Mos-Origins/GroundedOrigins/blob/fabric/1.18.1/.github/assets/ItemsSpritesheet.png?raw=true)
  - **Note**: _This replaces the old system "Fibrous Diet" power system, where you could eat otherwise inedible items like Leather, Paper, Wool, etc_
    - Flower Stamens
      - Crafted with 2 Flowers (any block/item with the `minecraft:flowers` tag)
      - OR
      - Crafted with 1 Spore Blossom
      - Applies "Health Boost" effect for 2 minutes
    - Fibrous String
      - Crafted with 1 Wool (any block/item with the `minecraft:wool` tag)
    - Paper Shreds
      - Crafted with 1 Paper
    - Book-Bite
      - Crafted with 1 Book
- Renamed `grounded_origins:moth/edible` tag to `grounded_origins:moth/fibrous_foods`
- Removed "Vegetarian" power from Moth origin
- "Fibrous Diet" Moth power overhaul
  - Remember the janky ability where you can eat Leather, Wool, String, etc? Well, this fully replaces that with new edible items!
  - Moths can now only eat foods in the `grounded_origins:moth/fibrous_foods` item tag, such as:
    - Flower Stamens
    - Fibrous String
    - Paper Shreds
    - Book-Bite
    - Apple
    - Carrot
    - Beetroot
    - Beetroot Soup
    - Sweet Berries
    - Glow Berries
    - Dried Kelp
  - Other Origins can technically eat the new foods added (Flower Stamens, Fibrous String, etc.) but only the Moth will gain hunger/saturation/effects from them
  - Updated description: _You can only eat bits of leather, paper, books, string, and wool that you can "craft". You can also eat other highly fibrous foods._
- "Pollenator" Moth power now uses Spore Blossom blocks alongside flowers
  - Updated description: _Having 15 flowers or 1 spore blossom within 20 blocks will make you far more resilient, and allow you to bonemeal the block you're standing on, as long as you aren't exposed to sunlight. Flower forests make you stronger._
- New "Nectar Production" Moth power
  - You gain 4 hunger shanks and 8 saturation by consuming Flower Stamens. Flower Stamens also give a health boost effect for 2 minutes
- "Aquatic Diet" Penguin power buff:
  - Foods in the `grounded_origins:penguin/seafood` tag no longer give any negative/postive effects
  - Consuming a Pufferfish gives Water Breathing for 3 minutes
- Updated localizations & ability descriptions
- File-structure changes & renaming


***


# **[1.0.1] - 2022/01/18**

### FABRIC:
- Added Quaternary keybind
- Fixed server crash

### BOTH:
- Changed Moth keybinds:
  - Pollenator Bonemeal: Secondary
  - Nocturnal: Ternary
  - Four Arms: Quaternary


***


# **[1.0.0] - 2022/01/16**

Release!