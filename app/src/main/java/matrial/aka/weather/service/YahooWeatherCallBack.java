package matrial.aka.weather.service;

import matrial.aka.weather.data.Channel;

/**
 * Created by geckozila on 15/06/16.
 */
public interface YahooWeatherCallBack {
void serviceSuccess (Channel channel);
void serviceFailure(Exception exception);
}
