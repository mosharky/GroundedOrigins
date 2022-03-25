[CHANGELOG](https://github.com/Mos-Origins/GroundedOrigins/blob/fabric/1.18.1/.github/CHANGELOG.md)
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