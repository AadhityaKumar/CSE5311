from selenium import webdriver
from selenium.webdriver.edge.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.keys import Keys
from selenium.webdriver import ActionChains
import os
import time

os.system("taskkill /f /im msedge.exe")
options = Options()

options.add_argument(r"user-data-dir=C:\Users\axk88\AppData\Local\Microsoft\Edge\User Data")

options.add_argument("profile-directory=Default")
options.add_experimental_option("detach", True)
options.add_argument("--safebrowsing-disable-download-protection")
options.add_argument("--safebrowsing-disable-extension-blacklist")
options.add_argument("--disable-extensions")
options.add_experimental_option(
    "prefs",
    {
        "download.default_directory": r"C:\AzureDevops\DeploymentTest",
        "download.prompt_for_download": False,
        "download.directory_upgrade": True,
        "safebrowsing.enabled": True,
        'download.extensions_to_open': 'msi'
    },
)


driver = webdriver.Edge(options=options)
driver.get("https://github.com/sentara-health/shp-834_IB_POST_ADDIN/raw/c5770a643ebdb684f0430170f542c0f01cafd547/Compiled%20Objects%20for%20Deployment/VPHP.DMAS.HIPAA5010834I.Post.Setup.msi")
#driver.execute_script("window.location.href = 'https://github.com/sentara-health/shp-834_IB_POST_ADDIN/raw/c5770a643ebdb684f0430170f542c0f01cafd547/Compiled%20Objects%20for%20Deployment/VPHP.DMAS.HIPAA5010834I.Post.Setup.msi';")
#search_bar = driver.find_element(By.NAME, "q")
#search_bar.send_keys("https://github.com/sentara-health/shp-834_IB_POST_ADDIN/raw/c5770a643ebdb684f0430170f542c0f01cafd547/Compiled%20Objects%20for%20Deployment/VPHP.DMAS.HIPAA5010834I.Post.Setup.msi", Keys.ENTER)
#driver.get("edge://downloads")