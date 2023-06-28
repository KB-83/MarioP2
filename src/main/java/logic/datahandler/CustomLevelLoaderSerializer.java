package logic.datahandler;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import logic.levelstructure.Level;
import logic.levelstructure.Section;
import logic.levelstructure.TeleSection;
import logic.modelstructure.backgroundobject.CheckPoint;
import logic.modelstructure.backgroundobject.block.Block;
import logic.modelstructure.backgroundobject.block.CoinBlock;
import logic.modelstructure.backgroundobject.block.EmptyBlock;
import logic.modelstructure.backgroundobject.block.QuestionBlock;
import logic.modelstructure.backgroundobject.block.SimpleBlock;
import logic.modelstructure.backgroundobject.pipe.*;
import logic.modelstructure.entity.enemy.*;
import logic.modelstructure.entity.item.Coin;
import logic.modelstructure.entity.item.Flower;
import logic.modelstructure.entity.item.Item;
import logic.modelstructure.entity.item.Mushroom;
import logic.modelstructure.entity.item.Star;
import util.Constant;

import java.io.IOException;

public class CustomLevelLoaderSerializer extends JsonSerializer<Level> {
    @Override
    public void serialize(Level level, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeStartObject();

        Section[] sections = level.getSections();
        if (sections != null && sections.length > 0) {
            jsonGenerator.writeFieldName("sections");
            jsonGenerator.writeStartArray();
            for (Section section : sections) {
                writeSection(section, jsonGenerator);
            }
            jsonGenerator.writeEndArray();
        }

        jsonGenerator.writeEndObject();
    }

    private void writeSection(Section section, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeNumberField("length", section.getLength());
        jsonGenerator.writeNumberField("time", section.getTime());

        writeCheckPoint(section.getCheckPoint(), jsonGenerator);
        writeBlocks(section.getBlocks(), jsonGenerator);
        writeEnemies(section.getEnemies(), jsonGenerator);
        writePipes(section.getPipes(), jsonGenerator);
        writeItems(section.getItems(), jsonGenerator);

        jsonGenerator.writeEndObject();
    }

    private void writeCheckPoint(CheckPoint checkPoint, JsonGenerator jsonGenerator) throws IOException {
        if (checkPoint != null) {
            jsonGenerator.writeObjectFieldStart("checkPoint");
            jsonGenerator.writeNumberField("col", checkPoint.getCol());
            jsonGenerator.writeNumberField("row", checkPoint.getRow());
            jsonGenerator.writeEndObject();
        }
    }

    private void writeBlocks(Block[] blocks, JsonGenerator jsonGenerator) throws IOException {
        if (blocks != null && blocks.length > 0) {
            jsonGenerator.writeArrayFieldStart("blocks");
            for (Block block : blocks) {
                writeBlock(block, jsonGenerator);
            }
            jsonGenerator.writeEndArray();
        }
    }

    private void writeBlock(Block block, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStartObject();

        if (block instanceof QuestionBlock) {
            jsonGenerator.writeStringField("type", "QUESTION");
        } else if (block instanceof SimpleBlock) {
            jsonGenerator.writeStringField("type", "SIMPLE");
        } else if (block instanceof CoinBlock) {
            jsonGenerator.writeStringField("type", "COIN");
        } else if (block instanceof EmptyBlock) {
            jsonGenerator.writeStringField("type", "EMPTY");
        }

        jsonGenerator.writeNumberField("x", block.getCol());
        jsonGenerator.writeNumberField("y", (Constant.PANEL_ROWS - Constant.GROUND_BLOCKS - 1) - block.getRow());

        if (block.getItem() != null) {
            writeItem(block.getItem(), jsonGenerator);
        }

        jsonGenerator.writeEndObject();
    }

    private void writeEnemies(Enemy[] enemies, JsonGenerator jsonGenerator) throws IOException {
        if (enemies != null && enemies.length > 0) {
            jsonGenerator.writeArrayFieldStart("enemies");
            for (Enemy enemy : enemies) {
                writeEnemy(enemy, jsonGenerator);
            }
            jsonGenerator.writeEndArray();
        }
    }

    private void writeEnemy(Enemy enemy, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStartObject();

        if (enemy instanceof Goomba) {
            jsonGenerator.writeStringField("type", "GOOMBA");
        } else if (enemy instanceof Koopa) {
            jsonGenerator.writeStringField("type", "KOOPA");
//        } else if (enemy instanceof Plant) {
//            jsonGenerator.writeStringField("type", "Plant");
//        } else if (enemy instanceof PiranhaPlant) {
//            jsonGenerator.writeStringField("type", "PIRANHA_PLANT");
        } else if (enemy instanceof Spiny) {
            jsonGenerator.writeStringField("type", "SPINY");
        } else if (enemy instanceof Bowser) {
            jsonGenerator.writeStringField("type", "BOWSER");
//        } else if (enemy instanceof BulletBill) {
//            jsonGenerator.writeStringField("type", "BULLET_BILL");
        }

        jsonGenerator.writeNumberField("x", enemy.getWorldX()/Constant.BACKGROUND_TILE_SIZE);
        jsonGenerator.writeNumberField("y", (Constant.PANEL_ROWS - Constant.GROUND_BLOCKS - 1) -enemy.getWorldY()/Constant.BACKGROUND_TILE_SIZE);

        jsonGenerator.writeEndObject();
    }

    private void writePipes(Pipe[] pipes, JsonGenerator jsonGenerator) throws IOException {
        if (pipes != null && pipes.length > 0) {
            jsonGenerator.writeArrayFieldStart("pipes");
            for (Pipe pipe : pipes) {
                writePipe(pipe, jsonGenerator);
            }
            jsonGenerator.writeEndArray();
        }
    }

    private void writePipe(Pipe pipe, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStartObject();

        if (pipe instanceof SimplePipe) {
            jsonGenerator.writeStringField("type", "SIMPLE");
        } else if (pipe instanceof SimpleTelePipe) {
            jsonGenerator.writeStringField("type", "TELE_SIMPLE");
        } else if (pipe instanceof SimplePlantPipe) {
            jsonGenerator.writeStringField("type", "PIRANHA_TRAP");
        } else if (pipe instanceof TelePlantPipe) {
            jsonGenerator.writeStringField("type", "TELE_PIRANHA");
        }
//        }else if (pipe instanceof SimpleSpawnPipe) {
//            jsonGenerator.writeStringField("type", "EXIT");
//        }

        jsonGenerator.writeNumberField("x", pipe.getCol());
        jsonGenerator.writeNumberField("y", (Constant.PANEL_ROWS - Constant.GROUND_BLOCKS - 1) - pipe.getRow());

        jsonGenerator.writeEndObject();
    }

    private void writeItems(Item[] items, JsonGenerator jsonGenerator) throws IOException {
        if (items != null && items.length > 0) {
            jsonGenerator.writeArrayFieldStart("items");
            for (Item item : items) {
                writeItem(item, jsonGenerator);
            }
            jsonGenerator.writeEndArray();
        }
    }

    private void writeItem(Item item, JsonGenerator jsonGenerator) throws IOException {

            if (item != null) {
                jsonGenerator.writeStringField("item", item.getClass().getSimpleName());
            }
    }
}

