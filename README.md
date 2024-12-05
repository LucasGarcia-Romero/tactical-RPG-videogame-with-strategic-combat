# Combat Game

A turn-based console combat game developed as a final project for Software Design course. Players battle against different enemies across various worlds, using different weapons and strategies.

## 🎮 Game Description

The game is a turn-based combat system where the player faces different enemies across multiple worlds/scenarios. Each turn, players can choose between attacking or defending. Combat continues until one contestant runs out of health points. With each victory, the player advances to the next world, facing new enemies with unique characteristics.

### Key Features

- Turn-based combat system
- Multiple worlds/scenarios (Forest, Ocean, Desert)
- Different enemy types with unique attributes
- Various weapons and combat strategies
- Health and damage calculation system
- State-based player system (Active, Damaged, Paralyzed)

## 🏗 Architecture

The project implements various design patterns to create a robust and maintainable codebase:

### Design Patterns Used

1. **Strategy Pattern**
   - Manages enemy combat strategies
   - Implements offensive, defensive, and default behaviors

2. **Decorator Pattern**
   - Handles weapon system and character attributes
   - Allows for flexible modification of character capabilities

3. **State Pattern**
   - Controls player states during combat
   - Manages transitions between Active, Damaged, and Paralyzed states

4. **Abstract Factory Pattern**
   - Creates different types of enemies
   - Adapts enemy characteristics to each world

5. **Singleton Pattern**
   - Implements in GameController and Calculator classes
   - Ensures single instance for critical game components

6. **Template Method Pattern**
   - Implements enemy algorithm decisions
   - Standardizes enemy behavior patterns

7. **Facade Pattern**
   - Simplifies game system interaction
   - Provides clean interface through GameController

## 🎯 Game Flow

1. Player starts in the first world
2. Each combat round consists of:
   - Player's turn (attack or defend)
   - Enemy's turn (based on strategy)
   - Damage calculation
   - State updates
3. Victory leads to next world
4. Game continues until player defeat or final world completion

## 👥 Authors

- Lucas García-Romero
- Diego García-Romero
- Alina Rojas
- Fernando Contreras
- Mar Iborra
- Laura Llorente
- Laia Delgado

## 📅 Course Information

- Course: Software Design
- Academic Year: 2022-2023

## 🔧 Technical Implementation

The game is implemented using various components and systems:

### Character System
- Base character attributes
- Customizable weapon inventory
- State management
- Health and damage calculations

### Enemy System
- Different enemy types (Warrior, Warlock, Miku)
- World-specific variations
- Strategic behavior patterns

### World System
- Multiple unique environments
- Progressive difficulty
- Enemy factory management

## 🎲 Game States

Players can experience different states during combat:
- **Active**: Ready for combat
- **Damaged**: Reduced capabilities after taking damage
- **Paralyzed**: Skip turn but recover health

