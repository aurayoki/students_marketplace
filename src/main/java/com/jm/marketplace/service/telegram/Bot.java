package com.jm.marketplace.service.telegram;

import com.jm.marketplace.dto.goods.AdvertisementDto;
import com.jm.marketplace.dto.goods.GoodsCategoryDto;
import com.jm.marketplace.dto.goods.GoodsSubcategoryDto;
import com.jm.marketplace.dto.goods.GoodsTypeDto;
import com.jm.marketplace.service.advertisement.AdvertisementService;
import com.jm.marketplace.service.goods.GoodsCategoryService;
import com.jm.marketplace.service.goods.GoodsSubcategoryService;
import com.jm.marketplace.service.goods.GoodsTypeService;
import com.jm.marketplace.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Slf4j
@PropertySource(value = "classpath:telegram.properties", encoding = "UTF-8")
public class Bot extends TelegramLongPollingBot {

    @Value("${bot.button.list_advertisement}")
    private String listAdvertisement;

    @Value("${bot.button.add_advertisement}")
    private String addAdvertisement;

    @Value("${bot.name}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    private final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    private final List<KeyboardRow> keyboard = new ArrayList<>();

    private AdvertisementService advertisementService;

    private HashMap<Long, Integer> currentGoodAddStatus = new HashMap<>();
    private HashMap<Long, AdvertisementDto> usersNewAdvertisement = new HashMap<>();

    private GoodsCategoryService goodsCategoryService;
    private GoodsSubcategoryService goodsSubcategoryService;
    private GoodsTypeService goodsTypeService;

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setGoodsCategoryService(GoodsCategoryService goodsCategoryService) {
        this.goodsCategoryService = goodsCategoryService;
    }

    @Autowired
    public void setGoodsSubcategoryService(GoodsSubcategoryService goodsSubcategoryService) {
        this.goodsSubcategoryService = goodsSubcategoryService;
    }

    @Autowired
    public void setGoodsTypeService(GoodsTypeService goodsTypeService) {
        this.goodsTypeService = goodsTypeService;
    }

    @Autowired
    public void setAdvertisementService(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @PostConstruct
    public void init() {
        configKeyboard();
    }

    public String getBotUsername() {
        return botUsername;
    }

    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {

            Long currentChatId = update.getMessage().getChatId();
            String currentMessageText = update.getMessage().getText();

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(currentChatId.toString());
            setButtons(sendMessage);

            if (currentMessageText.equals("Добавить товар")) {
                currentGoodAddStatus.put(currentChatId, 0);
                usersNewAdvertisement.put(currentChatId, new AdvertisementDto());
            }

            if (currentGoodAddStatus.containsKey(currentChatId)) {

                int currentGoodAddStatusId = currentGoodAddStatus.get(currentChatId);

                StringBuilder stringBuilder = new StringBuilder();

                if (currentGoodAddStatusId == 0) {

                    stringBuilder.append("Выберите категорию (отправьте цифру)").append("\n");

                    List<GoodsCategoryDto> goodsCategoryDtos = goodsCategoryService.findAll();

                    for (int i = 0; i < goodsCategoryDtos.size(); i++) {
                        stringBuilder.append((i + 1)).append(". ").append(goodsCategoryDtos.get(i).getName()).append("\n");
                    }

                    currentGoodAddStatus.put(currentChatId, currentGoodAddStatusId + 1);

                } else if (currentGoodAddStatusId == 1) {

                    AdvertisementDto advertisementDto = usersNewAdvertisement.get(currentChatId);
                    advertisementDto.setUser(userService.findById(1L));
                    advertisementDto.setGoodsCategory(goodsCategoryService.findById(Long.parseLong(currentMessageText)));
                    usersNewAdvertisement.put(currentChatId, advertisementDto);

                    List<GoodsSubcategoryDto> goodsSubcategoryDtos = goodsSubcategoryService.findByGoodsCategoryId(Long.parseLong(currentMessageText));

                    stringBuilder.append("Выберите подкатегорию (отправьте цифру)").append("\n");

                    for (int i = 0; i < goodsSubcategoryDtos.size(); i++) {
                        stringBuilder.append((i + 1)).append(". ").append(goodsSubcategoryDtos.get(i).getName()).append("\n");
                    }

                    currentGoodAddStatus.put(currentChatId, currentGoodAddStatusId + 1);

                } else if (currentGoodAddStatusId == 2) {

                    AdvertisementDto advertisementDto = usersNewAdvertisement.get(currentChatId);
                    advertisementDto.setGoodsSubcategory(goodsSubcategoryService.findById(Long.parseLong(currentMessageText)));
                    usersNewAdvertisement.put(currentChatId, advertisementDto);

                    List<GoodsTypeDto> goodsTypeDtos = goodsTypeService.findByGoodsSubcategoryId(Long.parseLong(currentMessageText));

                    stringBuilder.append("Выберите тип товара (отправьте цифру)").append("\n");

                    for (int i = 0; i < goodsTypeDtos.size(); i++) {
                        stringBuilder.append((i + 1)).append(". ").append(goodsTypeDtos.get(i).getName()).append("\n");
                    }

                    currentGoodAddStatus.put(currentChatId, currentGoodAddStatusId + 1);

                } else if (currentGoodAddStatusId == 3) {

                    AdvertisementDto advertisementDto = usersNewAdvertisement.get(currentChatId);
                    advertisementDto.setGoodsType(goodsTypeService.findById(Long.parseLong(currentMessageText)));
                    usersNewAdvertisement.put(currentChatId, advertisementDto);

                    stringBuilder.append("Введите название товара").append("\n");

                    currentGoodAddStatus.put(currentChatId, currentGoodAddStatusId + 1);

                } else if (currentGoodAddStatusId == 4) {

                    AdvertisementDto advertisementDto = usersNewAdvertisement.get(currentChatId);
                    advertisementDto.setName(currentMessageText);

                    stringBuilder.append("Введите описание товара").append("\n");

                    currentGoodAddStatus.put(currentChatId, currentGoodAddStatusId + 1);

                } else if (currentGoodAddStatusId == 5) {

                    AdvertisementDto advertisementDto = usersNewAdvertisement.get(currentChatId);
                    advertisementDto.setDescription(currentMessageText);
                    usersNewAdvertisement.put(currentChatId, advertisementDto);

                    stringBuilder.append("Введите цену товара").append("\n");

                    currentGoodAddStatus.put(currentChatId, currentGoodAddStatusId + 1);

                } else if (currentGoodAddStatusId == 6) {

                    AdvertisementDto advertisementDto = usersNewAdvertisement.get(currentChatId);
                    advertisementDto.setPrice(Integer.parseInt(currentMessageText));

                    advertisementService.saveOrUpdate(advertisementDto); //  в данный момент при добавлении в базу дает ошибку

                    stringBuilder.append("Объявление добавлено!").append("\n");

                    currentGoodAddStatus.remove(currentChatId);
                    usersNewAdvertisement.remove(currentChatId);

                }

                sendMessage.setText(stringBuilder.toString());

            } else {
                setMessage(sendMessage);
            }

            execute(sendMessage);
            log.info("Send telegram message, username: {}", update.getMessage().getFrom().getUserName());
        } catch (Exception e) {
            log.warn("Error with send telegram message");
            e.printStackTrace();
        }
    }

    private void setMessage(SendMessage sendMessage) {

        List<AdvertisementDto> advertisementDtos = advertisementService.findAll();
        StringBuilder sb = new StringBuilder(advertisementDtos.size());
        int count = 1;
        for (AdvertisementDto advertisementDto : advertisementDtos) {
            sb.append(count).append("\n");
            sb.append(advertisementDto.getName()).append("\n");
            sb.append(advertisementDto.getPrice()).append("\n");
            sb.append(advertisementDto.getDescription()).append("\n");
            sb.append("-------------------");
            sb.append("\n");
            count++;
        }
        sendMessage.setText(sb.toString());
    }

    private void setButtons(SendMessage sendMessage) {
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(listAdvertisement);
        keyboardFirstRow.add(addAdvertisement);
        keyboard.clear();
        keyboard.add(keyboardFirstRow);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
    }

    private void configKeyboard() {
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }
}