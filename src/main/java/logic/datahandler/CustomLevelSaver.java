package logic.datahandler;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import logic.levelstructure.Level;
import logic.levelstructure.Section;
import logic.modelstructure.backgroundobject.CheckPoint;
import logic.modelstructure.backgroundobject.block.*;
import logic.modelstructure.backgroundobject.pipe.*;
import logic.modelstructure.entity.enemy.*;
import logic.modelstructure.entity.item.*;
import util.Constant;

import java.io.IOException;

public class CustomLevelSaver extends JsonSerializer<Level> {
    @Override
    public void serialize(Level level, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeArrayFieldStart("sections");
        if (level.getSections() != null) {
            for (Section section : level.getSections()) {
                writeSection(jsonGenerator, section);
            }
        }
        jsonGenerator.writeEndArray();

        jsonGenerator.writeEndObject();
    }

    private void writeSection(JsonGenerator jsonGenerator, Section section) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeNumberField("length", section.getLength());
        jsonGenerator.writeNumberField("time", section.getTime());

        writeCheckPoint(jsonGenerator, section.getCheckPoint());

        writeBlocks(jsonGenerator, section.getBlocks());

        writeEnemies(jsonGenerator, section.getEnemies());

        writePipes(jsonGenerator, section.getPipes());

        writeItems(jsonGenerator, section.getItems());

        jsonGenerator.writeEndObject();
    }

    private void writeSpawnPipe(JsonGenerator jsonGenerator,Pipe spawnPipe) throws IOException {
        String type = "";
        switch (spawnPipe.getClass().getSimpleName()){
            case "SimpleSpawnPipe":
                type = "SIMPLE";
                break;
            case "SpawnPlantPipe":
                type = "PIRANHA_TRAP";
                break;

        }
        jsonGenerator.writeObjectFieldStart("spawnPipe");

        jsonGenerator.writeNumberField("x", spawnPipe.getCol());
        jsonGenerator.writeNumberField("y", (Constant.PANEL_ROWS - Constant.GROUND_BLOCKS - 1) - spawnPipe.getRow());
        if (!type.equals("")) {
            jsonGenerator.writeStringField("type", type);
        }
        jsonGenerator.writeEndObject();
    }
    private void writeCheckPoint(JsonGenerator jsonGenerator, CheckPoint checkPoint) throws IOException {
        if (checkPoint != null) {
            jsonGenerator.writeObjectFieldStart("checkPoint");
            jsonGenerator.writeBooleanField("isSaved", checkPoint.getSaved());
            jsonGenerator.writeNumberField("col", checkPoint.getCol());
            jsonGenerator.writeNumberField("row", checkPoint.getRow());
            jsonGenerator.writeNumberField("sectionNum", checkPoint.getSectionNum());
            jsonGenerator.writeEndObject();
        }
    }

    private void writeBlocks(JsonGenerator jsonGenerator, Block[] blocks) throws IOException {
        if (blocks != null && blocks.length > 0) {
            jsonGenerator.writeArrayFieldStart("blocks");
            for (Block block : blocks) {
                String type = "";
                switch (block.getClass().getSimpleName()){
                    case "SimpleBlock":
                        type = "SIMPLE";
                        break;
                    case "QuestionBlock":
                        type = "QUESTION";
                        break;
                    case "CoinBlock":
                        type = "COIN";
                        break;
                    case "FullCoinBlock":
                        type = "COINS";
                        break;

                }
                jsonGenerator.writeStartObject();
                if (!type.equals("")) {
                    jsonGenerator.writeStringField("type", type);
                }
                jsonGenerator.writeNumberField("x", block.getCol());
                jsonGenerator.writeNumberField("y", (Constant.PANEL_ROWS - Constant.GROUND_BLOCKS - 1) - block.getRow());
                writeItem(jsonGenerator, block.getItem());
                jsonGenerator.writeEndObject();
            }
            jsonGenerator.writeEndArray();
        }
    }

    private void writeItem(JsonGenerator jsonGenerator, Item item) throws IOException {
        if (item != null) {
            String type = "";

            switch (item.getClass().getSimpleName()){
                case "Flower":
                    type = "FLOWER";
                    break;
                case "Star":
                    type = "STAR";
                    break;
                case "Coin":
                    type = "COIN";
                    break;
                case "Mushroom":
                    type = "MUSHROOM";
                    break;

            }
            jsonGenerator.writeStringField("item", type);
        }
    }

    private void writeEnemies(JsonGenerator jsonGenerator, Enemy[] enemies) throws IOException {
        if (enemies != null && enemies.length > 0) {
            jsonGenerator.writeArrayFieldStart("enemies");
            for (Enemy enemy : enemies) {
                String type = "";

                switch (enemy.getClass().getSimpleName()){
                    case "Goomba":
                        type = "GOOMBA";
                        break;
                    case "Koopa":
                        type = "KOOPA";
                        break;
                    case "Spiny":
                        type = "SPINY";
                        break;
                    case "Bowser":
                        type = "BOWSER";
                        break;
                    case "Plant":
                        continue;

                }
                jsonGenerator.writeStartObject();
                if(!type.equals("")) {
                    jsonGenerator.writeStringField("type",type);
                }
                jsonGenerator.writeNumberField("x", enemy.getWorldX() / Constant.BACKGROUND_TILE_SIZE);
                jsonGenerator.writeNumberField("y", ((Constant.PANEL_ROWS - Constant.GROUND_BLOCKS - 1) - enemy.getWorldY() / Constant.BACKGROUND_TILE_SIZE));
                jsonGenerator.writeEndObject();
            }
            jsonGenerator.writeEndArray();
        }
    }

    private void writePipes(JsonGenerator jsonGenerator, Pipe[] pipes) throws IOException {
        if (pipes != null && pipes.length > 0) {
            jsonGenerator.writeArrayFieldStart("pipes");
            for (Pipe pipe : pipes) {
                String type = "";
                switch (pipe.getClass().getSimpleName()){
                    case "SimplePipe":
                        type = "SIMPLE";
                        break;
                    case "SimplePlantPipe":
                        type = "PIRANHA_TRAP";
                        break;
                    case "TelePlantPipe":
                        type = "TELE_PIRANHA";
                        break;
                    case "SimpleTelePipe":
                        type = "TELE_SIMPLE";
                        break;
                    case "SimpleSpawnPipe" :
                        continue;
                    case "SpawnPlantPipe" :
                        continue;

                }
                jsonGenerator.writeStartObject();

                jsonGenerator.writeNumberField("x", pipe.getCol());
                jsonGenerator.writeNumberField("y", (Constant.PANEL_ROWS - Constant.GROUND_BLOCKS - 1) - pipe.getRow());
                if (!type.equals("")) {
                    jsonGenerator.writeStringField("type", type);
                }
                if (type.equals("TELE_PIRANHA")){
//                    jsonGenerator.writeObjectFieldStart("section");
//                    jsonGenerator.writeStartObject();
//                    writeSection(jsonGenerator, ((TelePlantPipe)pipe).getTeleSection());
                    Section section = ((TelePlantPipe)pipe).getTeleSection();
                    jsonGenerator.writeObjectFieldStart("section");
                    jsonGenerator.writeNumberField("length", section.getLength());
                    jsonGenerator.writeNumberField("time", section.getTime());

                    writeCheckPoint(jsonGenerator, section.getCheckPoint());

                    writeBlocks(jsonGenerator, section.getBlocks());

                    writeEnemies(jsonGenerator, section.getEnemies());

                    writePipes(jsonGenerator, section.getPipes());

                    writeItems(jsonGenerator, section.getItems());
                    writeSpawnPipe(jsonGenerator, section.getSpawnPipe());

                    jsonGenerator.writeEndObject();
                }
                else if (type.equals("TELE_SIMPLE")){
                    Section section = ((TelePlantPipe)pipe).getTeleSection();
                    jsonGenerator.writeObjectFieldStart("section");
                    jsonGenerator.writeNumberField("length", section.getLength());
                    jsonGenerator.writeNumberField("time", section.getTime());

                    writeCheckPoint(jsonGenerator, section.getCheckPoint());

                    writeBlocks(jsonGenerator, section.getBlocks());

                    writeEnemies(jsonGenerator, section.getEnemies());

                    writePipes(jsonGenerator, section.getPipes());

                    writeItems(jsonGenerator, section.getItems());
                    writeSpawnPipe(jsonGenerator, section.getSpawnPipe());

                    jsonGenerator.writeEndObject();
                }
//                jsonGenerator.writeBooleanField("isStart", pipe instanceof StartPipe);
//                jsonGenerator.writeBooleanField("isEnd", pipe instanceof EndPipe);
                jsonGenerator.writeEndObject();
            }
            jsonGenerator.writeEndArray();
        }
    }

    private void writeItems(JsonGenerator jsonGenerator, Item[] items) throws IOException {
        if (items != null && items.length > 0) {
            jsonGenerator.writeArrayFieldStart("items");
            for (Item item : items) {
                String type = "";

                switch (item.getClass().getSimpleName()){
                    case "Flower":
                        type = "FLOWER";
                        break;
                    case "Star":
                        type = "STAR";
                        break;
                    case "Coin":
                        type = "COIN";
                        break;
                    case "Mushroom":
                        type = "MUSHROOM";
                        break;

                }
                jsonGenerator.writeStartObject();
                if (!type.equals("")) {
                    jsonGenerator.writeStringField("type", type);
                }
                jsonGenerator.writeNumberField("x", item.getWorldX() / Constant.BACKGROUND_TILE_SIZE);
                jsonGenerator.writeNumberField("y", ((Constant.PANEL_ROWS - Constant.GROUND_BLOCKS - 1) - item.getWorldY() / Constant.BACKGROUND_TILE_SIZE));
                jsonGenerator.writeEndObject();
            }
            jsonGenerator.writeEndArray();
        }
    }
}


