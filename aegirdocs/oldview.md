# BasicOre
    - EnergyOre(Block+pickaxe, Item, Ore-gen)                                   (d)
    - EnergyCrystal(Item)                       | loot(EnergyOre)               (d)
    - EnergyCrystalBlock(Block+pickaxe, Item)   | loot(EnergyCrystalBlock)      (x) 
    - PureCrystal(Item)                         | build(EnergyCrystal)          
    - Composite Materials
# BasicMachine
    - OreBuilder            | turn(EnergyCrystal -> PureCrystal)
    - PCR Instrument        | duplicate(*Slice -> *n)
    - DNA Cutter            | edit(*Slice)
    - Cell Importing Ins~   | turn(*Cell -> *Cell_new)
# Basic Tools & Items
    - Test Tube         | recipe(glasses/composite_material) | in(*Cell)
    - Empty Cell        | !out(entity)
    - Growth Medium     | in(*Cell) | duplicate(*Cell -> *n)
    - Original Cell     | out(entity) | build(EmptyCell in Container)
    - Container         | in(*Cell) | put(Cell Importing Ins~)
    - DNA/RNA Slice     | recipe( //TODO ) | put(PCR/DNA Cutter/
    - Classic Tool Set (sword, pickaxe...) 
# Entity
    - Cell Seaborn | from(Original Cell)
    - $EVOLUTION //TODO
# New Dimensions
    - //TODO
# Other 
    - Sealed Floor //TODO
