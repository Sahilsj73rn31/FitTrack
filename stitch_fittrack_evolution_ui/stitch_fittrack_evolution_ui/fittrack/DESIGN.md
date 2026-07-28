---
name: FitTrack
colors:
  surface: '#0c1609'
  surface-dim: '#0c1609'
  surface-bright: '#323c2d'
  surface-container-lowest: '#071105'
  surface-container-low: '#141e11'
  surface-container: '#182214'
  surface-container-high: '#222d1e'
  surface-container-highest: '#2d3828'
  on-surface: '#dae6d0'
  on-surface-variant: '#baccb0'
  inverse-surface: '#dae6d0'
  inverse-on-surface: '#293324'
  outline: '#85967c'
  outline-variant: '#3c4b35'
  surface-tint: '#2ae500'
  primary: '#efffe3'
  on-primary: '#053900'
  primary-container: '#39ff14'
  on-primary-container: '#107100'
  inverse-primary: '#106e00'
  secondary: '#66dd8b'
  on-secondary: '#003919'
  secondary-container: '#25a55a'
  on-secondary-container: '#003115'
  tertiary: '#fff8f7'
  on-tertiary: '#442927'
  tertiary-container: '#ffd3ce'
  on-tertiary-container: '#7a5955'
  error: '#ffb4ab'
  on-error: '#690005'
  error-container: '#93000a'
  on-error-container: '#ffdad6'
  primary-fixed: '#79ff5b'
  primary-fixed-dim: '#2ae500'
  on-primary-fixed: '#022100'
  on-primary-fixed-variant: '#095300'
  secondary-fixed: '#83fba5'
  secondary-fixed-dim: '#66dd8b'
  on-secondary-fixed: '#00210c'
  on-secondary-fixed-variant: '#005227'
  tertiary-fixed: '#ffdad6'
  tertiary-fixed-dim: '#e7bdb8'
  on-tertiary-fixed: '#2c1513'
  on-tertiary-fixed-variant: '#5d3f3c'
  background: '#0c1609'
  on-background: '#dae6d0'
  surface-variant: '#2d3828'
typography:
  headline-xl:
    fontFamily: Space Grotesk
    fontSize: 40px
    fontWeight: '700'
    lineHeight: 48px
    letterSpacing: -0.02em
  headline-lg:
    fontFamily: Space Grotesk
    fontSize: 32px
    fontWeight: '600'
    lineHeight: 40px
    letterSpacing: -0.01em
  headline-lg-mobile:
    fontFamily: Space Grotesk
    fontSize: 28px
    fontWeight: '600'
    lineHeight: 36px
  headline-md:
    fontFamily: Space Grotesk
    fontSize: 24px
    fontWeight: '600'
    lineHeight: 32px
  body-lg:
    fontFamily: Inter
    fontSize: 18px
    fontWeight: '400'
    lineHeight: 28px
  body-md:
    fontFamily: Inter
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 24px
  label-lg:
    fontFamily: Space Grotesk
    fontSize: 14px
    fontWeight: '600'
    lineHeight: 20px
    letterSpacing: 0.05em
  label-md:
    fontFamily: Space Grotesk
    fontSize: 12px
    fontWeight: '500'
    lineHeight: 16px
    letterSpacing: 0.08em
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  container-margin: 20px
  gutter-grid: 16px
  stack-sm: 8px
  stack-md: 16px
  stack-lg: 24px
  stack-xl: 40px
---

## Brand & Style

This design system establishes a high-performance, futuristic aesthetic tailored for elite fitness tracking. The brand personality is hyper-modern, energetic, and technologically advanced, aiming to make the user feel like they are operating a sophisticated biometric dashboard.

The visual style leverages **Glassmorphism** and **Dark Futurism**. By using deep matte blacks and dark charcoal as a foundation, the UI allows neon accents to achieve maximum luminance. The interface utilizes high-end translucent layers, background blurs, and subtle glow effects to create a sense of depth and digital sophistication. Every interaction should feel fluid and responsive, mimicking a futuristic heads-up display (HUD).

## Colors

The palette is rooted in a "Matte Black" environment to minimize ocular strain and maximize contrast for data visualization. 

- **Primary Accent (Neon Green):** Used for critical action buttons, active states, and progress indicators. It should carry a subtle outer glow (0px 0px 12px) to simulate a light-emitting surface.
- **Secondary Accent (Emerald):** Used for supportive data visualizations, secondary progress metrics, and success states to provide a sophisticated tonal range.
- **Surface Layers:** The secondary background (#141414) provides subtle separation from the canvas. Glassmorphic cards use a semi-transparent white overlay (approx. 8-12% opacity) combined with a heavy backdrop blur (20px - 40px) to create the "frosted" futuristic effect.

## Typography

The typography strategy balances technical precision with high readability. **Space Grotesk** is used for headings and labels to lean into the sci-fi/technical aesthetic with its geometric apertures. **Inter** is utilized for body text and data values to ensure maximum clarity during high-intensity activity.

For data-heavy screens, use `label-md` for secondary metadata to maintain a clean hierarchy. Headlines should always use a tighter letter-spacing to feel more "locked-in" and engineered.

## Layout & Spacing

This design system uses a **Fluid Grid** model optimized for mobile-first consumption. 
- **Grid:** A 4-column system for mobile, scaling to 12 columns for tablet/desktop. 
- **Safe Zones:** Maintain a 20px horizontal margin at all times.
- **Rhythm:** An 8px base unit drives all spacing. Elements should be grouped with 16px (medium) or 24px (large) vertical gaps to prevent visual clutter in the dark interface.
- **Metric Grids:** Health metrics are housed in a 2x2 responsive grid, where each card maintains a 1:1 aspect ratio when possible.

## Elevation & Depth

Depth is conveyed through **backlight and transparency** rather than traditional drop shadows.
- **Level 0 (Base):** Matte Black (#0B0B0B).
- **Level 1 (Sub-surface):** Dark Charcoal (#141414) used for list backgrounds or secondary sections.
- **Level 2 (Glass Cards):** Semi-transparent white (8%) with a 30px Backdrop Blur and a subtle 1px inner stroke (White at 10% opacity) to define the edge.
- **Level 3 (Floating Elements):** High-opacity glass with a soft "Neon Green" ambient glow (15% opacity) cast underneath the element to suggest it is powered by light.

## Shapes

The shape language is "Organic-Tech." We use generous corner radii to offset the "cold" feel of the dark futuristic theme, making the app feel more human-centric and wearable-inspired. 

All main cards and interactive containers should utilize the `rounded-xl` (24px) setting. Smaller elements like chips or input fields should use `rounded-lg` (16px).

## Components

- **Bottom Navigation:** Fixed glassmorphic bar. Use a 40px backdrop blur. Active states feature a 4px Neon Green "dot" or "pill" indicator below the icon, accompanied by a soft green glow.
- **Hero Cards:** Feature an animated SVG progress ring. The ring uses a gradient stroke (Emerald to Neon Green). The center of the ring displays the primary metric in `headline-xl`.
- **Health Metric Cards:** 2x2 grid. Each card features a Material Rounded icon in the top left, a title in `label-md`, and the value in `headline-md`.
- **Activity Chips:** Horizontal scrolling. Unselected: Dark Charcoal with thin border. Selected: Neon Green background with Black text.
- **AI Coach Chat:** The "Coach" bubbles use the primary Neon Green as a subtle glow-border; the "User" bubbles are standard glassmorphic cards.
- **Input Fields:** Minimalist. A single bottom border in Dark Gray that transitions to Neon Green on focus, with a slight "glow" transition.
- **Progress Rings:** Always use rounded caps for strokes to match the global roundedness of the system.