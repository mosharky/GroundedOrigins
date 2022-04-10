[CHANGELOG](https://github.com/Mos-Origins/GroundedOrigins/blob/fabric/1.18.1/.github/CHANGELOG.md)
# **[1.1.2] - 2022/04/10**

### FORGE:
- The Moth origin's Pollinator and Phototactic powers are back, the FPS issue has been fixed!

All thanks to [EdwinMindcraft](https://www.curseforge.com/members/edwinmindcraft/projects) for creating the new `grounded_origins:cube_check` power and entity condition in [this pull request](https://github.com/Mos-Origins/GroundedOrigins/pull/4)! You can find documentation on this [here](https://github.com/Mos-Origins/GroundedOrigins/wiki/Power-types-&-Conditions-Documentation)

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